package com.bysj.staff_training.dao;

import com.bysj.staff_training.pojo.TrainingResult;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("trainingResultMapper")
public interface TrainingResultMapper {
    public int addTrainingResult(TrainingResult trainingResult);
    public List<TrainingResult> findTrainingResultByASC(int taskId);
    public List<TrainingResult> findTrainingResultByDESC(int taskId);
    public List<TrainingResult> findTotalTrainingResultByDESC(int authorId);
    public List<TrainingResult> findTotalTrainingResultByASC(int authorId);
    public List<TrainingResult> findAllTrainingResultByStaffId(int staffId);
    public TrainingResult findTrainingResultById(int trainingResId);
    public int submitFeedBack(TrainingResult trainingResult);
}
