package com.bysj.staff_training.pojo;

import java.io.Serializable;

public class TrainingResult implements Serializable {
    private int trainingResId;
    private int taskId;
    private String taskName;
    private int choiceScore;
    private int essayScore;
    private int totalScore;
    private int authorId;
    private int staffId;
    private String staffName;
    private String trainerFeedBack;
    private String staffAdvice;
    private String staffFeedBack;

    public TrainingResult() {

    }

    public TrainingResult(int trainingResId, int taskId, String taskName, int choiceScore, int essayScore, int totalScore, int authorId,
                          int staffId, String staffName, String trainerFeedBack, String staffAdvice, String staffFeedBack) {
        this.trainingResId = trainingResId;
        this.taskId = taskId;
        this.taskName = taskName;
        this.choiceScore = choiceScore;
        this.essayScore = essayScore;
        this.totalScore = totalScore;
        this.authorId = authorId;
        this.staffId = staffId;
        this.trainerFeedBack = trainerFeedBack;
        this.staffAdvice = staffAdvice;
        this.staffFeedBack = staffFeedBack;
        this.staffName = staffName;
    }

    public TrainingResult(int taskId, String taskName, int choiceScore, int essayScore, int totalScore, int authorId,
                          int staffId, String staffName, String trainerFeedBack) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.choiceScore = choiceScore;
        this.essayScore = essayScore;
        this.totalScore = totalScore;
        this.authorId = authorId;
        this.staffId = staffId;
        this.trainerFeedBack = trainerFeedBack;
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getTrainingResId() {
        return trainingResId;
    }

    public void setTrainingResId(int trainingResId) {
        this.trainingResId = trainingResId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(int choiceScore) {
        this.choiceScore = choiceScore;
    }

    public int getEssayScore() {
        return essayScore;
    }

    public void setEssayScore(int essayScore) {
        this.essayScore = essayScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
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

    public String getTrainerFeedBack() {
        return trainerFeedBack;
    }

    public void setTrainerFeedBack(String trainerFeedBack) {
        this.trainerFeedBack = trainerFeedBack;
    }

    public String getStaffAdvice() {
        return staffAdvice;
    }

    public void setStaffAdvice(String staffAdvice) {
        this.staffAdvice = staffAdvice;
    }

    public String getStaffFeedBack() {
        return staffFeedBack;
    }

    public void setStaffFeedBack(String staffFeedBack) {
        this.staffFeedBack = staffFeedBack;
    }

    @Override
    public String toString() {
        return "TrainingResult{" +
                "trainingResId=" + trainingResId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", choiceScore=" + choiceScore +
                ", essayScore=" + essayScore +
                ", totalScore=" + totalScore +
                ", authorId=" + authorId +
                ", staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", trainerFeedBack='" + trainerFeedBack + '\'' +
                ", staffAdvice='" + staffAdvice + '\'' +
                ", staffFeedBack='" + staffFeedBack + '\'' +
                '}';
    }
}
