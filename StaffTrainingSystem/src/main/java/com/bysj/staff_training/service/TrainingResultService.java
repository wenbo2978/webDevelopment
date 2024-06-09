package com.bysj.staff_training.service;

import com.bysj.staff_training.pojo.TrainingResult;

import java.util.List;

public interface TrainingResultService {
    public int addTrainingResult(TrainingResult trainingResult);
    public List<TrainingResult> findTrainingResultByOrder(String order, int taskId, int authorId);
    public List<TrainingResult> findAllTrainingResultByStaffId(int staffId);
    public TrainingResult findTrainingResultById(int trainingResId);
    public int submitFeedBack(TrainingResult trainingResult);
}
