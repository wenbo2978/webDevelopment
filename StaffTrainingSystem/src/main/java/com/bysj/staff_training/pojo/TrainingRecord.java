package com.bysj.staff_training.pojo;

import java.io.Serializable;

public class TrainingRecord implements Serializable {
    private int trainingRId;
    private int taskId;
    private int staffId;
    private int authorId;
    private String taskName;
    private String staffName;
    private String end_Time;
    private String lastOperation_Time;
    private double process;
    private String isFinished;
    private String isEvaluated;
    private String feedBack;
    //private int count;
    //private int count_Finish;
    //private int count_Assessment;
    private static final long serialVersionUID = 1L;

    public TrainingRecord() {
    }

    public TrainingRecord(int taskId, int staffId, int authorId, String taskName, String staffName, String end_Time, String lastOperation_Time, double process, String isFinished, String isEvaluated) {
        this.taskId = taskId;
        this.staffId = staffId;
        this.authorId = authorId;
        this.taskName = taskName;
        this.end_Time = end_Time;
        this.lastOperation_Time = lastOperation_Time;
        this.process = process;
        this.isFinished = isFinished;
        this.isEvaluated = isEvaluated;
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getTrainingRId() {
        return trainingRId;
    }

    public void setTrainingRId(int trainingRId) {
        this.trainingRId = trainingRId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(String end_Time) {
        this.end_Time = end_Time;
    }

    public String getLastOperation_Time() {
        return lastOperation_Time;
    }

    public void setLastOperation_Time(String lastOperation_Time) {
        this.lastOperation_Time = lastOperation_Time;
    }

    public double getProcess() {
        return process;
    }

    public void setProcess(double process) {
        this.process = process;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public String getIsEvaluated() {
        return isEvaluated;
    }

    public void setIsEvaluated(String isEvaluated) {
        this.isEvaluated = isEvaluated;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    @Override
    public String toString() {
        return "TrainingRecord{" +
                "trainingRId=" + trainingRId +
                ", taskId=" + taskId +
                ", staffId=" + staffId +
                ", authorId=" + authorId +
                ", taskName='" + taskName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", end_Time='" + end_Time + '\'' +
                ", lastOperation_Time='" + lastOperation_Time + '\'' +
                ", process=" + process +
                ", isFinished='" + isFinished + '\'' +
                ", isEvaluated='" + isEvaluated + '\'' +
                ", feedBack='" + feedBack + '\'' +
                '}';
    }
}
