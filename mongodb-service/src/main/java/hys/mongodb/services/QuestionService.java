package hys.mongodb.services;/**
 * @Author: csj
 * @Description:
 * @Date: 2019/9/2 9:26
 */

import hys.mongodb.beans.Pager;
import hys.mongodb.constant.ExamConstant;
import hys.mongodb.manage.MongoDBManager;
import hys.mongodb.manage.Reader;
import hys.mongodb.manage.Writer;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rmjk.bean.mgdb.Question;
import rmjk.common.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author csj
 * @Date 2019/9/2 9:26
 **/
@Service
public class QuestionService {
    /**
     * 日志记录器
     */
    private static final Logger LOG = LoggerFactory.getLogger(CommentService.class);

    @Resource
    private MongoDBManager manager;
    @Resource
    private Writer writer;

    @Resource
    private Reader reader;

    public void saveOrUpdateQuestion(Question data) {
        if (StringUtils.isEmpty(data.getId())) {// 新增
            writer.insert(manager.getExamDataBase(), ExamConstant.QUESTION_COLLECT, data);
        } else {
            UpdateQuestion(data);
        }
    }

    private void UpdateQuestion(Question data) {
        writer.updateDocument(data, ExamConstant.QUESTION_COLLECT);
    }

    public void delQuestion(String id) {
        Document filter = new Document();
        filter.put("id", id);
        writer.delete(manager.getExamDataBase(), ExamConstant.QUESTION_COLLECT, filter);
    }

    public Question question(String id) {
        return reader.findOne(manager.getExamDataBase(), ExamConstant.QUESTION_COLLECT, new Document("id", id), Question.class);
    }

    public List<Question> listQuestion(String dataId, Integer pageNo, Integer pageSize) {
        Document cnd = new Document();
        if (dataId != null) {
            cnd.put("dataId", dataId);
        }
        Pager pager = null;
        if (pageNo != null && pageSize != null) {
            pager = new Pager();
            pager.setPageNumber(pageNo);
            pager.setPageSize(pageSize);
        }

        return reader.read(manager.getExamDataBase(), ExamConstant.QUESTION_COLLECT, cnd, pager, Question.class);
    }

}
