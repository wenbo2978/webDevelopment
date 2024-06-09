package com.bysj.staff_training.service.impl;

import com.bysj.staff_training.dao.TaskChoiceMapper;
import com.bysj.staff_training.pojo.TaskChoice;
import com.bysj.staff_training.pojo.TrainingRecord;
import com.bysj.staff_training.service.TaskChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskChoiceServiceImpl implements TaskChoiceService {

    @Autowired
    TaskChoiceMapper taskChoiceMapper;

    @Override
    public int addTaskChoice(TaskChoice taskChoice) {
        return taskChoiceMapper.addTaskChoice(taskChoice);
    }

    @Override
    public int updateTaskChoice(TaskChoice taskChoice) {
        return taskChoiceMapper.updateTaskChoice(taskChoice);
    }

    @Override
    public int deleteTaskChoice(int taskChoiceId) {
        return taskChoiceMapper.deleteTaskChoice(taskChoiceId);
    }

    @Override
    public List<TaskChoice> getAllChoiceByTaskId_Trainer(int taskId) {
        return taskChoiceMapper.getAllChoiceByTaskId_Trainer(taskId);
    }

    @Override
    public int deleteAllChoiceByTaskId(int taskId) {
        return taskChoiceMapper.deleteAllChoiceByTaskId(taskId);
    }

    @Override
    public TaskChoice getChoiceById(int taskChoiceId) {
        return taskChoiceMapper.getChoiceById(taskChoiceId);
    }

    @Override
    public int addPublishedTaskChoice(TaskChoice taskChoice) {
        return taskChoiceMapper.addPublishedTaskChoice(taskChoice);
    }

    @Override
    public List<TaskChoice> findAllChoiceByTaskIdAndStaffId(TrainingRecord trainingRecord) {
        return taskChoiceMapper.findAllChoiceByTaskIdAndStaffId(trainingRecord);
    }

    @Override
    public int saveChoiceAnswer(TaskChoice taskChoice) {
        return taskChoiceMapper.saveChoiceAnswer(taskChoice);
    }

    @Override
    public int finishChoiceAnswer(int taskChoiceId) {
        return taskChoiceMapper.finishChoiceAnswer(taskChoiceId);
    }
}
