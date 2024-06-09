package com.bysj.staff_training.pojo;

import java.io.Serializable;

public class Task implements Serializable {
    private int taskId;
    private String taskName;
    private String scope;
    private String begin_Time;
    private String end_Time;
    private String attachment;
    private int authorId;
    private String isPublished;
    private String category;
    private static final long serialVersionUID = 1L;

    public Task(){
    }

    public Task(String taskName, String scope, String category, String begin_Time, String end_Time, String attachment, int authorId) {
        this.taskName = taskName;
        this.scope = scope;
        this.begin_Time = begin_Time;
        this.end_Time = end_Time;
        this.attachment = attachment;
        this.category = category;
        this.authorId = authorId;
    }

    public Task(String taskName, String scope, String category, String begin_Time, String end_Time, String attachment) {
        this.taskName = taskName;
        this.scope = scope;
        this.begin_Time = begin_Time;
        this.end_Time = end_Time;
        this.attachment = attachment;
        this.category = category;
    }

    public Task(String taskName, String scope, String category, String begin_Time, String end_Time, String attachment, String isPublished, int authorId) {
        this.taskName = taskName;
        this.scope = scope;
        this.begin_Time = begin_Time;
        this.end_Time = end_Time;
        this.attachment = attachment;
        this.category = category;
        this.authorId = authorId;
        this.isPublished = isPublished;
    }

    public Task(int taskId, String taskName, String scope, String category, String begin_Time, String end_Time, String attachment, int authorId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.scope = scope;
        this.begin_Time = begin_Time;
        this.end_Time = end_Time;
        this.attachment = attachment;
        this.authorId = authorId;
        this.category = category;
    }

    public Task(int taskId, String taskName, String scope, String category, String begin_Time, String end_Time, String attachment) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.scope = scope;
        this.begin_Time = begin_Time;
        this.end_Time = end_Time;
        this.attachment = attachment;
        this.category = category;

    }

    public int getTaskId(){
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getBegin_Time() {
        return begin_Time;
    }

    public void setBegin_Time(String begin_Time) {
        this.begin_Time = begin_Time;
    }

    public String getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(String end_Time) {
        this.end_Time = end_Time;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", scope='" + scope + '\'' +
                ", begin_Time='" + begin_Time + '\'' +
                ", end_Time='" + end_Time + '\'' +
                ", attachment='" + attachment + '\'' +
                ", authorId=" + authorId +
                ", isPublished='" + isPublished + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
