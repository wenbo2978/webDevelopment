package com.bysj.staff_training.service.impl;

import com.bysj.staff_training.dao.TaskEssayMapper;
import com.bysj.staff_training.pojo.TaskEssay;
import com.bysj.staff_training.pojo.TrainingRecord;
import com.bysj.staff_training.service.TaskEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskEssayServiceImpl implements TaskEssayService {

    @Autowired
    TaskEssayMapper taskEssayMapper;

    @Override
    public int addTaskEssay(TaskEssay taskEssay) {
        return taskEssayMapper.addTaskEssay(taskEssay);
    }

    @Override
    public int updateTaskEssay(TaskEssay taskEssay) {
        return taskEssayMapper.updateTaskEssay(taskEssay);
    }

    @Override
    public int deleteTaskEssay(int taskEssayId) {
        return taskEssayMapper.deleteTaskEssay(taskEssayId);
    }

    @Override
    public List<TaskEssay> getAllEssayByTaskId_Trainer(int taskId) {
        return taskEssayMapper.getAllEssayByTaskId_Trainer(taskId);
    }

    @Override
    public int deleteAllEssayByTaskId(int taskId) {
        return taskEssayMapper.deleteAllEssayByTaskId(taskId);
    }

    @Override
    public TaskEssay getEssayById(int taskEssayId) {
        return taskEssayMapper.getEssayById(taskEssayId);
    }

    @Override
    public int addPublishedTaskEssay(TaskEssay taskEssay) {
        return taskEssayMapper.addPublishedTaskEssay(taskEssay);
    }

    @Override
    public List<TaskEssay> findAllEssayByTaskIdAndStaffId(TrainingRecord trainingRecord) {
        return taskEssayMapper.findAllEssayByTaskIdAndStaffId(trainingRecord);
    }

    @Override
    public int saveEssayAnswer(TaskEssay taskEssay) {
        return taskEssayMapper.saveEssayAnswer(taskEssay);
    }

    @Override
    public int finishEssayAnswer(int taskEssayId) {
        return taskEssayMapper.finishEssayAnswer(taskEssayId);
    }

    @Override
    public int updateEssayScore(TaskEssay taskEssay) {
        return taskEssayMapper.updateEssayScore(taskEssay);
    }
}
