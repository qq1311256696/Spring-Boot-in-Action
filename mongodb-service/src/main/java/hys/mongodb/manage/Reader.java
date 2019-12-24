package hys.mongodb.manage;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import hys.mongodb.beans.Pager;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Reader {
    @Resource(name = "commentClient")
    private MongoClient commentClient;

    @Resource(name = "examClient")
    private MongoClient examClient;

    /**
     * 数据存储
     *
     * @param dataBase 数据库
     * @param collect  业务代码，一个业务代码对应一个数据集
     */
    public <T> List<T> read(String dataBase, String collect, Bson cnd, Pager pager, Class<T> clazz) {
        final List<T> results = new ArrayList<>();
        Block<Document> iteratorResults = document -> {
            JSONObject jo = new JSONObject(document);
            results.add(JSONObject.toJavaObject(jo, clazz));
        };

        MongoDatabase db = getDatabase(dataBase);
        MongoCollection<Document> collection = db.getCollection(collect);

        if (pager == null) {
            collection.find(cnd).sort(new BasicDBObject("insTime", 1))
                    .forEach(iteratorResults);
        } else {
            collection.find(cnd).sort(new BasicDBObject("insTime", pager.getSort()))
                    .skip((pager.getPageNumber() - 1) * pager.getPageSize())
                    .limit(pager.getPageSize())
                    .forEach(iteratorResults);
        }
        return results;
    }

    /**
     * 返回总数
     *
     * @param dataBase 数据库
     * @param collect  业务代码，一个业务代码对应一个数据集
     */
    public long count(String dataBase, String collect, Bson cnd) {
        MongoDatabase db = getDatabase(dataBase);
        MongoCollection<Document> collection = db.getCollection(collect);

        if (cnd == null) {
            return collection.count();
        } else {
            return collection.count(cnd);
        }
    }

    /**
     * 查询一个
     */
    public <T> T findOne(String dataBase, String collect, Bson bson, Class<T> clazz) {
        Document document = getDatabase(dataBase).getCollection(collect).find(bson).first();
        if (document != null) {
            JSONObject jo = new JSONObject(document);
            return JSONObject.toJavaObject(jo, clazz);
        } else {
            return null;
        }
    }

    /**
     * 随机查询数据
     */
    public <T> List<T> findRandom(String dataBase, String collect, Bson bson, Class<T> clazz, int no) {
        final List<T> results = new ArrayList<>();
        Block<Document> iteratorResults = document -> {
            JSONObject jo = new JSONObject(document);
            results.add(JSONObject.toJavaObject(jo, clazz));
        };
        getDatabase(dataBase).getCollection(collect).find(bson).limit(no).skip((int) (Math.random() * 30)).forEach(iteratorResults);
        return results;
    }

    private MongoDatabase getDatabase(String dataBase) {
        if (dataBase.equals("exam")) {
            return examClient.getDatabase(dataBase);
        } else {
            return commentClient.getDatabase(dataBase);
        }
    }
}
