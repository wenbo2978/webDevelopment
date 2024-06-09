package com.bysj.staff_training.service.impl;

import com.bysj.staff_training.dao.TrainingResultMapper;
import com.bysj.staff_training.pojo.TrainingResult;
import com.bysj.staff_training.service.TrainingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TrainingResultServiceImpl implements TrainingResultService {

    @Autowired
    TrainingResultMapper trainingResultMapper;

    @Override
    public int addTrainingResult(TrainingResult trainingResult) {
        return trainingResultMapper.addTrainingResult(trainingResult);
    }

    @Override
    public List<TrainingResult> findTrainingResultByOrder(String order, int taskId, int authorId) {
        if(order.equals("Descending")){
            if(taskId == 0)
                return trainingResultMapper.findTotalTrainingResultByDESC(authorId);
            else
                return trainingResultMapper.findTrainingResultByDESC(taskId);
        }else{
            if(taskId == 0)
                return trainingResultMapper.findTotalTrainingResultByASC(authorId);
            return trainingResultMapper.findTrainingResultByASC(taskId);
        }
    }

    @Override
    public List<TrainingResult> findAllTrainingResultByStaffId(int staffId) {
        return trainingResultMapper.findAllTrainingResultByStaffId(staffId);
    }

    @Override
    public TrainingResult findTrainingResultById(int trainingResId) {
        return trainingResultMapper.findTrainingResultById(trainingResId);
    }

    @Override
    public int submitFeedBack(TrainingResult trainingResult) {
        return trainingResultMapper.submitFeedBack(trainingResult);
    }
}
