package com.bysj.staff_training.dao;

import com.bysj.staff_training.pojo.TaskEssay;
import com.bysj.staff_training.pojo.TrainingRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("taskEssayMapper")
public interface TaskEssayMapper {
    public int addTaskEssay(TaskEssay taskEssay);
    public int updateTaskEssay(TaskEssay taskEssay);
    public int deleteTaskEssay(int taskEssayId);
    public List<TaskEssay> getAllEssayByTaskId_Trainer(int taskId);
    public int deleteAllEssayByTaskId(int taskId);
    public TaskEssay getEssayById(int taskEssayId);
    public int addPublishedTaskEssay(TaskEssay taskEssay);
    public List<TaskEssay> findAllEssayByTaskIdAndStaffId(TrainingRecord trainingRecord);
    public int saveEssayAnswer(TaskEssay taskEssay);
    public int finishEssayAnswer(int taskEssayId);
    public int updateEssayScore(TaskEssay taskEssay);
}
