package com.bysj.staff_training.service;

import com.bysj.staff_training.pojo.Task;
import com.bysj.staff_training.pojo.TotalTrainingRecord;

import java.util.List;

public interface TaskService {
    public List<Task> findAllTaskByTrainer(int trainerId);
    public int deleteTask(int taskId);
    public int addTask(Task task);
    public int updateTask(Task task);
    public List<Task> findAllUnpublishedTaskByTrainer(int trainerId);
    public int publishTask(int taskId, int authorId);
    public Task getTaskByTaskId(int taskId);
    public List<TotalTrainingRecord> findTotalTrainingRecord(int authorId);
    public List<Task> findAllTask(int authorId);
}
