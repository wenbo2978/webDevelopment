package com.bysj.staff_training.dao;

import com.bysj.staff_training.pojo.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("taskMapper")
public interface TaskMapper {
    List<Task> findAllTaskByTrainer(int trainerId);
    int addTask(Task task);
    int updateTask(Task task);
    int deleteTask(int taskId);
    List<Task> findAllUnpublishedTaskByTrainer(int trainerId);
    int publishTask(int taskId);
    Task getTaskByTaskId(int taskId);
    List<Task> findAllPublishedTaskByTrainer(int trainerId);
}
