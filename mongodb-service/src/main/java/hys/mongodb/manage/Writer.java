package hys.mongodb.manage;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import hys.mongodb.utils.BsonTool;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;
import rmjk.bean.MongoBean;
import rmjk.common.StringUtils;

import javax.annotation.Resource;

@Repository
public class Writer {

    @Resource(name = "commentClient")
    private MongoClient commentClient;

    @Resource(name = "examClient")
    private MongoClient examClient;

    @Resource
    private MongoDBManager manager;
    /**
     * 数据存储
     *
     * @param dataBase 数据库
     * @param collect  业务代码，一个业务代码对应一个数据集
     * @param data     存储的数据
     */
    public void insert(String dataBase, String collect, MongoBean data) {
        if (StringUtils.isEmpty(data.getId())) {
            data.setId(BsonTool.uuid());
        }
        MongoCollection<Document> collection = getCollection(dataBase, collect);
        collection.insertOne(Document.parse(JSONObject.toJSONString(data)));
    }

    public Document updateDocument(MongoBean data, String questionCollect) {
        Document filter = new Document();
        filter.put("id", data.getId());
        Document res = new Document();
        res.put("$set", BsonDocument.parse(JSONObject.toJSONString(data)));
        update(manager.getExamDataBase(), questionCollect, filter, res);
        return res;
    }

    /**
     * @param dataBase 数据库
     * @param collect  集合
     * @param filter   过滤条件
     * @param update   更新对象
     */
    public boolean update(String dataBase, String collect, Bson filter, Bson update) {
        MongoCollection<Document> collection = getCollection(dataBase, collect);
        UpdateResult ur = collection.updateOne(filter, update);
        return ur.getModifiedCount() > 0;
    }

    /**
     * 当数据存在时更新数据，数据不存在时插入数据
     *
     * @param dataBase
     * @param collect
     * @param filter
     * @param update
     * @return
     */
    public boolean upsert(String dataBase, String collect, Document filter, Document update) {
        MongoCollection<Document> collection = getCollection(dataBase, collect);
        //UpdateResult ur = collection.updateOne(filter, update);
        UpdateResult ur = collection.replaceOne(filter, update, new UpdateOptions().upsert(true));
        //UpdateResult ur = collection.updateOne(filter, update, new UpdateOptions().upsert(true));
        return ur.getModifiedCount() > 0;
    }

    /**
     * 删除文档
     *
     * @param dataBase
     * @param collect
     * @param filter
     */
    public boolean delete(String dataBase, String collect, Bson filter) {
        MongoCollection<Document> collection = getCollection(dataBase, collect);
        DeleteResult dr = collection.deleteOne(filter);
        return dr.getDeletedCount() > 0;
    }

    private MongoCollection<Document> getCollection(String dataBase, String collect) {
        MongoDatabase db = getDatabase(dataBase);
        return db.getCollection(collect);
    }


    private MongoDatabase getDatabase(String dataBase) {
        if (dataBase.equals("exam")) {
            return examClient.getDatabase(dataBase);
        } else {
            return commentClient.getDatabase(dataBase);
        }
    }
    /**
     * 数据存储
     *

     */
   /* public void writeMany(long tenantId, String code, List<Record> data, MongoClient mongoClient) {
        MongoDatabase db = mongoClient.getDatabase("DB_" + tenantId);
        MongoCollection<Document> collection = db.getCollection(code);
        List<Document> documents = new ArrayList<>();
        int page = 0;
        for (int i = 0; i < data.size(); i++) {
            if (i <= (page + 1) * PAGESIZE && i >= page * PAGESIZE) {
                Record d = data.get(i);
                if (!d.containsKey("data_time")) {
                    d.put("data_time", new Date());
                }
                documents.add(Document.parse(JSONObject.toJSONString(d)));
            }else{
                page ++;
                collection.insertMany(documents);
                documents = new ArrayList<>();
            }
        }
        if (page > 0 || (data.size() <  PAGESIZE) ) {
            collection.insertMany(documents);
        }
    }*/


}
