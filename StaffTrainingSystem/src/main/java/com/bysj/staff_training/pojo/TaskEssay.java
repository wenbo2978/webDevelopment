package com.bysj.staff_training.pojo;

import java.io.Serializable;

public class TaskEssay implements Serializable {
    private int taskEssayId;
    private int taskId;
    private int authorId;
    private int staffId;
    private String taskQ;
    private String answer;
    private String isFinished;
    private int score;
    private static final long serialVersionUID = 1L;

    public TaskEssay() {
    }

    public TaskEssay(int taskId, int authorId, int staffId, String taskQ, String isFinished, int score) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.staffId = staffId;
        this.taskQ = taskQ;
        this.isFinished = isFinished;
        this.score = score;
    }

    public TaskEssay(int taskEssayId, int taskId, int authorId, int staffId, String taskQ, String isFinished, int score) {
        this.taskEssayId = taskEssayId;
        this.taskId = taskId;
        this.authorId = authorId;
        this.staffId = staffId;
        this.taskQ = taskQ;
        this.isFinished = isFinished;
        this.score = score;
    }

    public TaskEssay(int taskId, int authorId, String taskQ) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.taskQ = taskQ;
    }

    public TaskEssay(int taskEssayId, int taskId, int authorId, String taskQ) {
        this.taskEssayId = taskEssayId;
        this.taskId = taskId;
        this.authorId = authorId;
        this.taskQ = taskQ;
    }

    public TaskEssay(int taskEssayId, String taskQ) {
        this.taskEssayId = taskEssayId;
        this.taskQ = taskQ;
    }

    public int getTaskEssayId() {
        return taskEssayId;
    }

    public void setTaskEssayId(int taskEssayId) {
        this.taskEssayId = taskEssayId;
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

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getTaskQ() {
        return taskQ;
    }

    public void setTaskQ(String taskQ) {
        this.taskQ = taskQ;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TaskEssay{" +
                "taskEssayId=" + taskEssayId +
                ", taskId=" + taskId +
                ", authorId=" + authorId +
                ", staffId=" + staffId +
                ", taskQ='" + taskQ + '\'' +
                ", answer='" + answer + '\'' +
                ", isFinished='" + isFinished + '\'' +
                ", score=" + score +
                '}';
    }
}
