package hys.mongodb.manage;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * MongoDB管理器
 */
@Component
public class MongoDBManager {
    /**
     * URI
     */
    @Value("${hys.mongodb.comment.uri}")
    private String commentUri;
    /**
     * dataBase
     */
    @Value("${hys.mongodb.comment.dataBase}")
    private String commentDataBase;

    /**
     * URI
     */
    @Value("${hys.mongodb.exam.uri}")
    private String examUri;
    /**
     * dataBase
     */
    @Value("${hys.mongodb.exam.dataBase}")
    private String examDataBase;

    /**
     * 获取 MongoClient 对象，可以只创建一个
     *
     * @return MongoClient对象
     */
    @Bean(name = "commentClient")
    public MongoClient commentClient() {
        System.out.println("\n\n\n\n\n" + commentUri + commentDataBase);
        return new MongoClient(new MongoClientURI(commentUri + commentDataBase));
    }

    /**
     * 获取 MongoClient 对象，可以只创建一个
     *
     * @return MongoClient对象
     */
    @Bean(name = "examClient")
    public MongoClient examClient() {
        System.out.println("\n\n\n\n\n" + examUri + examDataBase);
        return new MongoClient(new MongoClientURI(examUri + examDataBase));
    }

    public String getCommentUri() {
        return commentUri;
    }

    public void setCommentUri(String commentUri) {
        this.commentUri = commentUri;
    }

    public String getCommentDataBase() {
        return commentDataBase;
    }

    public void setCommentDataBase(String commentDataBase) {
        this.commentDataBase = commentDataBase;
    }

    public String getExamUri() {
        return examUri;
    }

    public void setExamUri(String examUri) {
        this.examUri = examUri;
    }

    public String getExamDataBase() {
        return examDataBase;
    }

    public void setExamDataBase(String examDataBase) {
        this.examDataBase = examDataBase;
    }
}
