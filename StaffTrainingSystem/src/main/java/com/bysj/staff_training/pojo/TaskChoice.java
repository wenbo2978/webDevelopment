package com.bysj.staff_training.pojo;

import java.io.Serializable;

public class TaskChoice implements Serializable {
    private int taskChoiceId;
    private int taskId;
    private int authorId;
    private int staffId;
    private String taskQ;
    private String taskChoiceA;
    private String taskChoiceB;
    private String taskChoiceC;
    private String taskChoiceD;
    private String correctAnswer;
    private String answer;
    private String isFinished;
    private String isCorrect;
    private static final long serialVersionUID = 1L;

    public TaskChoice() {
    }

    public TaskChoice(int taskId, int authorId, int staffId, String taskQ, String taskChoiceA, String taskChoiceB, String taskChoiceC, String taskChoiceD, String correctAnswer, String isFinished) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.staffId = staffId;
        this.taskQ = taskQ;
        this.taskChoiceA = taskChoiceA;
        this.taskChoiceB = taskChoiceB;
        this.taskChoiceC = taskChoiceC;
        this.taskChoiceD = taskChoiceD;
        this.correctAnswer = correctAnswer;
        this.isFinished = isFinished;
    }

    public TaskChoice(int taskId, int authorId, String taskQ, String taskChoiceA, String taskChoiceB, String taskChoiceC, String taskChoiceD, String correctAnswer) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.taskQ = taskQ;
        this.taskChoiceA = taskChoiceA;
        this.taskChoiceB = taskChoiceB;
        this.taskChoiceC = taskChoiceC;
        this.taskChoiceD = taskChoiceD;
        this.correctAnswer = correctAnswer;
    }

    public TaskChoice(int taskChoiceId, int taskId, int authorId, String taskQ, String taskChoiceA, String taskChoiceB, String taskChoiceC, String taskChoiceD, String correctAnswer) {
        this.taskChoiceId = taskChoiceId;
        this.taskId = taskId;
        this.authorId = authorId;
        this.taskQ = taskQ;
        this.taskChoiceA = taskChoiceA;
        this.taskChoiceB = taskChoiceB;
        this.taskChoiceC = taskChoiceC;
        this.taskChoiceD = taskChoiceD;
        this.correctAnswer = correctAnswer;
    }

    public TaskChoice(int taskChoiceId, String taskQ, String taskChoiceA, String taskChoiceB, String taskChoiceC, String taskChoiceD, String correctAnswer) {
        this.taskChoiceId = taskChoiceId;
        this.taskQ = taskQ;
        this.taskChoiceA = taskChoiceA;
        this.taskChoiceB = taskChoiceB;
        this.taskChoiceC = taskChoiceC;
        this.taskChoiceD = taskChoiceD;
        this.correctAnswer = correctAnswer;
    }

    public TaskChoice(int taskChoiceId, int taskId, int authorId, int staffId, String taskQ, String taskChoiceA, String taskChoiceB, String taskChoiceC, String taskChoiceD, String correctAnswer, String isFinished) {
        this.taskChoiceId = taskChoiceId;
        this.taskId = taskId;
        this.authorId = authorId;
        this.staffId = staffId;
        this.taskQ = taskQ;
        this.taskChoiceA = taskChoiceA;
        this.taskChoiceB = taskChoiceB;
        this.taskChoiceC = taskChoiceC;
        this.taskChoiceD = taskChoiceD;
        this.correctAnswer = correctAnswer;
        this.isFinished = isFinished;
    }



    public int getTaskChoiceId() {
        return taskChoiceId;
    }

    public void setTaskChoiceId(int taskChoiceId) {
        this.taskChoiceId = taskChoiceId;
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

    public String getTaskChoiceA() {
        return taskChoiceA;
    }

    public void setTaskChoiceA(String taskChoiceA) {
        this.taskChoiceA = taskChoiceA;
    }

    public String getTaskChoiceB() {
        return taskChoiceB;
    }

    public void setTaskChoiceB(String taskChoiceB) {
        this.taskChoiceB = taskChoiceB;
    }

    public String getTaskChoiceC() {
        return taskChoiceC;
    }

    public void setTaskChoiceC(String taskChoiceC) {
        this.taskChoiceC = taskChoiceC;
    }

    public String getTaskChoiceD() {
        return taskChoiceD;
    }

    public void setTaskChoiceD(String taskChoiceD) {
        this.taskChoiceD = taskChoiceD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
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

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "TaskChoice{" +
                "taskChoiceId=" + taskChoiceId +
                ", taskId=" + taskId +
                ", authorId=" + authorId +
                ", staffId=" + staffId +
                ", taskQ='" + taskQ + '\'' +
                ", taskChoiceA='" + taskChoiceA + '\'' +
                ", taskChoiceB='" + taskChoiceB + '\'' +
                ", taskChoiceC='" + taskChoiceC + '\'' +
                ", taskChoiceD='" + taskChoiceD + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", answer='" + answer + '\'' +
                ", isFinished='" + isFinished + '\'' +
                ", isCorrect='" + isCorrect + '\'' +
                '}';
    }
}
