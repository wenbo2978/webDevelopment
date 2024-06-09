package com.bysj.staff_training.service;

import com.bysj.staff_training.pojo.TrainingRecord;

import java.util.List;

public interface TrainingRecordService {
    public int addTrainingRecord(TrainingRecord trainingRecord);
    public List<TrainingRecord> findTrainingRecordByTaskId(int taskId);
    public TrainingRecord findTrainingRecordById(int trainingRId);
    public List<String> getOperationAccess(TrainingRecord trainingRecord);
    public List<TrainingRecord> findAllTrainingRecordByStaff(int staffId);
    public boolean ifTaskFinished(int trainingRId);
    public int updateTrainingProcessing(int trainingRId);
    public int finishTrainingRecord(int trainingRId);
    public int submitEvaluation(int trainingRId, String feedBack);
    public int submitDue(int trainingRId, String feedBack);
}
