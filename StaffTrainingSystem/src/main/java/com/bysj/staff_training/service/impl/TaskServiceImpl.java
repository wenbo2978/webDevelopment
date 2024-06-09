package com.bysj.staff_training.service.impl;


import com.bysj.staff_training.dao.TaskMapper;
import com.bysj.staff_training.pojo.*;
import com.bysj.staff_training.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    TaskChoiceService taskChoiceService;

    @Autowired
    TaskEssayService taskEssayService;

    @Autowired
    UserService userService;

    @Autowired
    TrainingRecordService trainingRecordService;

    @Override
    public List<Task> findAllTaskByTrainer(int trainerId) {
        return taskMapper.findAllTaskByTrainer(trainerId);
    }

    @Override
    public int deleteTask(int taskId) {
        return taskMapper.deleteTask(taskId);
    }

    @Override
    public int addTask(Task task) {
        return taskMapper.addTask(task);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateTask(task);
    }

    @Override
    public List<Task> findAllUnpublishedTaskByTrainer(int trainerId) {
        return taskMapper.findAllUnpublishedTaskByTrainer(trainerId);
    }

    @Override
    public Task getTaskByTaskId(int taskId){
        return taskMapper.getTaskByTaskId(taskId);
    }

    @Override
    public int publishTask(int taskId, int authorId) {
        taskMapper.publishTask(taskId);
        Task task = taskMapper.getTaskByTaskId(taskId);
        List<TaskEssay> taskEssayList = taskEssayService.getAllEssayByTaskId_Trainer(taskId);
        List<TaskChoice> taskChoiceList = taskChoiceService.getAllChoiceByTaskId_Trainer(taskId);
        List<User> userList = userService.findUserByAuthority("Staff");
        for(User u : userList){
            System.out.println(u);
            for(TaskEssay te: taskEssayList){
                te.setStaffId(u.getUserid());
                te.setIsFinished("unFinished");
                te.setScore(0);
                taskEssayService.addPublishedTaskEssay(te);
            }
            for(TaskChoice tc : taskChoiceList){
                tc.setStaffId(u.getUserid());
                tc.setIsFinished("unFinished");

                taskChoiceService.addPublishedTaskChoice(tc);
            }
            TrainingRecord trainingRecord = new TrainingRecord(taskId, u.getUserid(), authorId, task.getTaskName(),
                    u.getUsername(), task.getEnd_Time(), "", 0, "unFinished",
                    "unEvaluated");
            trainingRecordService.addTrainingRecord(trainingRecord);
        }
        return 1;
    }

    @Override
    public List<TotalTrainingRecord> findTotalTrainingRecord(int authorId){
        List<TotalTrainingRecord> totalTrainingRecordList = new ArrayList<>();
        List<Task> taskList = taskMapper.findAllPublishedTaskByTrainer(authorId);
        for(Task task: taskList){
            List<TrainingRecord> trainingRecordList = trainingRecordService.findTrainingRecordByTaskId(task.getTaskId());
            TotalTrainingRecord total = new TotalTrainingRecord();

            total.setTaskId(task.getTaskId());
            total.setAuthorId(authorId);
            total.setTaskName(task.getTaskName());
            total.setEnd_Time(task.getEnd_Time());
            total.setAmount(0);
            total.setFinishedAmount(0);
            total.setEvaluatedAmount(0);
            for(TrainingRecord tr : trainingRecordList){
                total.setAmount(total.getAmount() + 1);
                if(tr.getIsEvaluated().equals("Evaluated"))
                    total.setEvaluatedAmount(total.getEvaluatedAmount() + 1);
                if(tr.getIsFinished().equals("Finished"))
                    total.setFinishedAmount(total.getFinishedAmount() + 1);
            }
            totalTrainingRecordList.add(total);
        }
        return totalTrainingRecordList;
    }

    @Override
    public List<Task> findAllTask(int authorId) {
        List<Task> tasks = taskMapper.findAllPublishedTaskByTrainer(authorId);

        return tasks;
    }
}
