package hys.mongodb.enums;

import rmjk.enums.BizTypeEnum;

import java.util.Arrays;

public enum BizFieldEnum {
    /**
     * 文章
     */
    ARTICLE("article", "id", -1, BizTypeEnum.ARTICLE_COMMENT),
    /**
     * 短视频
     */
    SHORT_VIDOE("short_video", "vid", -1, BizTypeEnum.SHORT_VIDEO_COMMENT),
    /**
     * 帖子
     */
    POST("post", "pid", 1, BizTypeEnum.POST);

    /*
    表名
     */
    private String bizName;
    /*
    在表中的主键
     */
    private String field;
    /*
    返回列表的排序是时间正序还是时间倒序
     */
    private Integer order;
    /*
    数据的类型
     */
    private BizTypeEnum dataType;

    BizFieldEnum(String bizName, String field, int order, BizTypeEnum type) {
        this.bizName = bizName;
        this.field = field;
        this.order = order;
        this.dataType = type;
    }

    public static String getFieldByBiz(String bizName) {
        return Arrays.stream(BizFieldEnum.values()).filter(v -> v.getBizName().equals(bizName)).findFirst().get().getField();
    }

    public static Integer getOrder(String bizName) {
        return Arrays.stream(BizFieldEnum.values()).filter(v -> v.getBizName().equals(bizName)).findFirst().get().getOrder();
    }

    public static Integer getDataType(String bizName) {
        return Arrays.stream(BizFieldEnum.values()).filter(v -> v.getBizName().equals(bizName)).findFirst().get().getDataType().getCode();
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public BizTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(BizTypeEnum dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "BizFieldEnum{" +
                "bizName='" + bizName + '\'' +
                ", field='" + field + '\'' +
                ", order=" + order +
                '}';
    }
}
