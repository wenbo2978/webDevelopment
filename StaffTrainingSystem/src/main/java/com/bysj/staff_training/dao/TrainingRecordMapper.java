package com.bysj.staff_training.dao;

import com.bysj.staff_training.pojo.TrainingRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("trainingRecordMapper")
public interface TrainingRecordMapper {
    public int addTrainingRecord(TrainingRecord trainingRecord);
    public List<TrainingRecord> findTrainingRecordByTaskId(int taskId);
    public TrainingRecord findTrainingRecordById(int trainingRId);
    public List<TrainingRecord> findAllTrainingRecordByStaff(int staffId);
    public int updateTrainingProcessing(TrainingRecord trainingRecord);
    public int finishTrainingRecord(int trainingRId);
    public int submitEvaluation(TrainingRecord trainingRecord);
}
