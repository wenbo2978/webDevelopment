package com.bysj.staff_training.service;

import com.bysj.staff_training.pojo.TaskChoice;
import com.bysj.staff_training.pojo.TrainingRecord;

import java.util.List;

public interface TaskChoiceService {
    public int addTaskChoice(TaskChoice taskChoice);
    public int updateTaskChoice(TaskChoice taskChoice);
    public int deleteTaskChoice(int taskChoiceId);
    public List<TaskChoice> getAllChoiceByTaskId_Trainer(int taskId);
    int deleteAllChoiceByTaskId(int taskId);
    public TaskChoice getChoiceById(int taskChoiceId);
    public int addPublishedTaskChoice(TaskChoice taskChoice);
    public List<TaskChoice> findAllChoiceByTaskIdAndStaffId(TrainingRecord trainingRecord);
    public int saveChoiceAnswer(TaskChoice taskChoice);
    public int finishChoiceAnswer(int taskChoiceId);
}
