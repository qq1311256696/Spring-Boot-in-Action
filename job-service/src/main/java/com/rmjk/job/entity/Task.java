package com.rmjk.job.entity;

import java.util.Date;

public class Task {
    private String id;

    private String title;

    private Date beganTime;

    private Date endTime;

    private Date remindTime;

    private String location;

    private String userId;

    private Byte isFinished = 0;

    private String taskCategoryId;

    private String notation;

    public Task(String id, String title, Date beganTime, Date endTime, Date remindTime, String location, String userId, Byte isFinished, String taskCategoryId, String notation) {
        this.id = id;
        this.title = title;
        this.beganTime = beganTime;
        this.endTime = endTime;
        this.remindTime = remindTime;
        this.location = location;
        this.userId = userId;
        this.isFinished = isFinished;
        this.taskCategoryId = taskCategoryId;
        this.notation = notation;
    }

    public Task() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getBeganTime() {
        return beganTime;
    }

    public void setBeganTime(Date beganTime) {
        this.beganTime = beganTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Byte getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Byte isFinished) {
        this.isFinished = isFinished;
    }

    public String getTaskCategoryId() {
        return taskCategoryId;
    }

    public void setTaskCategoryId(String taskCategoryId) {
        this.taskCategoryId = taskCategoryId == null ? null : taskCategoryId.trim();
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation == null ? null : notation.trim();
    }
}
