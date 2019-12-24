package hys.mongodb.beans;

/**
 * @Author: csj
 * @Description: 用于推送时的标题
 * @Date: 2019/5/21 13:49
 */
public class BizData {
    /*
    文章的id
     */
    private Long id;
    /*
    短视频和直播的id
     */
    private Long vid;

    /*
    帖子作者的id
     */
    private Long authorId;

    /*
    作者类型：1用户，2医生
     */
    private Short authorType;

    /*
    标题
     */
    private String title;

    public BizData() {
    }

    public BizData(String bizId) {
        this.id = Long.parseLong(bizId);
        this.vid = Long.parseLong(bizId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Short getAuthorType() {
        return authorType;
    }

    public void setAuthorType(Short authorType) {
        this.authorType = authorType;
    }

    @Override
    public String toString() {
        return "BizData{" +
                "id=" + id +
                ", vid=" + vid +
                ", authorId=" + authorId +
                ", authorType=" + authorType +
                ", title='" + title + '\'' +
                '}';
    }

    /**
     * 空对象
     */
    private static final BizData empty_bean = new BizData();

    public static BizData build() {
        return empty_bean;
    }
}
