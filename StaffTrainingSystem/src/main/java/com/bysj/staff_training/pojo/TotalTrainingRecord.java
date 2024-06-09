package com.bysj.staff_training.pojo;

import java.io.Serializable;

public class TotalTrainingRecord implements Serializable {
    //private int trainingRId;
    private int taskId;
    private int authorId;
    private String taskName;
    private String end_Time;
    private int amount;
    private int finishedAmount;
    private int evaluatedAmount;
    private static final long serialVersionUID = 1L;

    public TotalTrainingRecord() {
    }

    public TotalTrainingRecord(int taskId, int authorId, String taskName, String end_Time, int amount, int finishedAmount, int evaluatedAmount) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.taskName = taskName;
        this.end_Time = end_Time;
        this.amount = amount;
        this.finishedAmount = finishedAmount;
        this.evaluatedAmount = evaluatedAmount;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFinishedAmount() {
        return finishedAmount;
    }

    public void setFinishedAmount(int finishedAmount) {
        this.finishedAmount = finishedAmount;
    }

    public int getEvaluatedAmount() {
        return evaluatedAmount;
    }

    public void setEvaluatedAmount(int evaluatedAmount) {
        this.evaluatedAmount = evaluatedAmount;
    }

    @Override
    public String toString() {
        return "TotalTrainingRecord{" +
                "taskId=" + taskId +
                ", authorId=" + authorId +
                ", taskName='" + taskName + '\'' +
                ", end_Time='" + end_Time + '\'' +
                ", amount=" + amount +
                ", finishedAmount=" + finishedAmount +
                ", evaluatedAmount=" + evaluatedAmount +
                '}';
    }
}
