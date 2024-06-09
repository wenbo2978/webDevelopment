package com.bysj.staff_training.dao;

import com.bysj.staff_training.pojo.TaskChoice;
import com.bysj.staff_training.pojo.TrainingRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("taskChoiceMapper")
public interface TaskChoiceMapper {
    public int addTaskChoice(TaskChoice taskChoice);
    public int updateTaskChoice(TaskChoice taskChoice);
    public int deleteTaskChoice(int taskChoiceId);
    public List<TaskChoice> getAllChoiceByTaskId_Trainer(int taskId);
    public int deleteAllChoiceByTaskId(int taskId);
    public TaskChoice getChoiceById(int taskChoiceId);
    public int addPublishedTaskChoice(TaskChoice taskChoice);
    public List<TaskChoice> findAllChoiceByTaskIdAndStaffId(TrainingRecord trainingRecord);
    public int saveChoiceAnswer(TaskChoice taskChoice);
    public int finishChoiceAnswer(int taskChoiceId);
}
