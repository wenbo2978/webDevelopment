package com.bysj.staff_training.controller;

import com.bysj.staff_training.pojo.*;
import com.bysj.staff_training.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrainerActionTest {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskChoiceService taskChoiceService;

    @Autowired
    TaskEssayService taskEssayService;

    @Autowired
    TrainingRecordService trainingRecordService;

    @Autowired
    TrainingResultService trainingResultService;

    @Test
    public void findAllTaskByTrainer(){
        int trainerId = 2;
        List<Task> taskList = taskService.findAllTaskByTrainer(trainerId);
        for(Task t : taskList){
            System.out.println(t);
        }
    }

    @Test
    public void addTask(){
        Task task = new Task("DataStructure2", "Staff", "Professional",
                "2024-06-04", "2024-06-14", "DataStructure2.txt",
                "unPublished", 2);
        taskService.addTask(task);
    }

    @Test
    public void updateTask(){
        int taskId = 4;
        String taskName = "newOOP4";
        String scope = "Staff";
        String category = "Professional";
        String begin_Time = "2024-06-08";
        String end_Time = "2024-06-15";
        String attachment = "oop2.txt";
        Task task = new Task(taskId, taskName, scope, category, begin_Time, end_Time, attachment);
        taskService.updateTask(task);
    }

    @Test
    public void deleteTask(){
        int taskId = 4;
        taskService.deleteTask(taskId);
        taskChoiceService.deleteAllChoiceByTaskId(taskId);
        taskEssayService.deleteAllEssayByTaskId(taskId);
    }

    @Test
    public void findAllUnpublishedTask(){
        int trainerId = 2;
        List<Task> taskList = taskService.findAllUnpublishedTaskByTrainer(trainerId);
        for(Task t : taskList){
            System.out.println(t);
        }
    }

    @Test
    public void addTaskChoice(){
        int taskId = 4;
        int authorId = 2;
        String taskQ = "which language is not oop language?";
        String taskChoiceA = "C++";
        String taskChoiceB = "C";
        String taskChoiceC = "Java";
        String taskChoiceD = "Python";
        String correctAnswer = "B";
        TaskChoice taskChoice = new TaskChoice(taskId, authorId, taskQ, taskChoiceA, taskChoiceB,
                taskChoiceC, taskChoiceD, correctAnswer);

        taskChoiceService.addTaskChoice(taskChoice);

    }

    @Test
    public void deleteTaskChoice(){
        int taskChoiceId = 1;
        taskChoiceService.deleteTaskChoice(taskChoiceId);
    }

    @Test
    public void updateTaskChoice(){
        int taskChoiceId = 1;
        int taskId = 1;
        int authorId = 2;
        String taskQ = "which language is not oop language?";
        String taskChoiceA = "C++";
        String taskChoiceB = "C";
        String taskChoiceC = "Java";
        String taskChoiceD = "Python";
        String correctAnswer = "B";
        TaskChoice taskChoice = new TaskChoice(taskChoiceId, taskId, authorId, taskQ, taskChoiceA, taskChoiceB,
                taskChoiceC, taskChoiceD, correctAnswer);
        taskChoiceService.updateTaskChoice(taskChoice);
    }

    @Test
    public void addTaskEssay(){
        int taskId = 4;
        int authorId = 2;
        String taskQ = "What is oop?";
        TaskEssay taskEssay = new TaskEssay(taskId, authorId, taskQ);
        taskEssayService.addTaskEssay(taskEssay);
    }

    @Test
    public void updateTaskEssay(){
        int taskEssayId = 1;
        int taskId = 1;
        int authorId = 2;
        String taskQ = "can you explain what is oop?";
        TaskEssay taskEssay = new TaskEssay(taskEssayId, taskId, authorId, taskQ);
        taskEssayService.updateTaskEssay(taskEssay);
    }

    @Test
    public void deleteTaskEssay(){
        int taskEssayId = 1;
        taskEssayService.deleteTaskEssay(taskEssayId);
    }

    @Test
    public void getTaskContentByTaskId_Trainer(){
        int taskId = 1;
        List<TaskEssay> taskEssayList = taskEssayService.getAllEssayByTaskId_Trainer(taskId);
        for(TaskEssay te : taskEssayList){
            System.out.println(te);
        }
        List<TaskChoice> choiceList = taskChoiceService.getAllChoiceByTaskId_Trainer(taskId);
        for(TaskChoice tc : choiceList){
            System.out.println(tc);
        }

    }

    @Test
    public void getEssayById(){
        TaskEssay taskEssay = taskEssayService.getEssayById(2);
        System.out.println(taskEssay);
    }

    @Test
    public void getChoiceById(){
        TaskChoice taskChoice = taskChoiceService.getChoiceById(2);
        System.out.println(taskChoice);
    }

    @Test
    public void publishTask(){
        int taskId = 1;
        int authorId = 2;
        taskService.publishTask(taskId, authorId);
    }

    @Test
    public void getTotalTrainingRecord(){
        int authorId = 2;
        List<TotalTrainingRecord> totalList = taskService.findTotalTrainingRecord(authorId);
        for(TotalTrainingRecord total : totalList){
            System.out.println(total.toString());
        }
    }


    @Test
    public void getRecordDetail(){
        int taskId = 3;
        List<TrainingRecord> trainingRecordList = trainingRecordService.findTrainingRecordByTaskId(taskId);
        for(TrainingRecord tr: trainingRecordList){
            System.out.println(tr.toString());
        }
    }

    @Test
    public void getStaffRecordDetail(){
        int trainingRId = 5;
        TrainingRecord trainingRecord = trainingRecordService.findTrainingRecordById(trainingRId);
        List<String> res = trainingRecordService.getOperationAccess(trainingRecord);
        String due = res.get(0);
        String ifCanMakeEvaluate = res.get(1);
        System.out.println(due + ", " + ifCanMakeEvaluate);
        List<TaskChoice> taskChoiceList = taskChoiceService.findAllChoiceByTaskIdAndStaffId(trainingRecord);
        List<TaskEssay> taskEssayList = taskEssayService.findAllEssayByTaskIdAndStaffId(trainingRecord);
        for(TaskChoice tc : taskChoiceList)
            System.out.println(tc);
        for(TaskEssay te: taskEssayList)
            System.out.println(te);

    }

    /*
    分割线
     */
    @Test
    public void updateEssayScore(){
        int score = 6;
        int taskEssayId = 12;
        TaskEssay essay = new TaskEssay();
        essay.setTaskEssayId(taskEssayId);
        essay.setScore(score);
        taskEssayService.updateEssayScore(essay);
    }

    @Test
    public void submitEvaluation(){
        int trainingRId = 5;
        String feedBack = "pass";
        trainingRecordService.submitEvaluation(trainingRId, feedBack);
    }

    @Test
    public void submitDue(){
        int trainingRId = 6;
        String feedBack = "overDue";
        trainingRecordService.submitDue(trainingRId, feedBack);
    }

    @Test
    public void findAllTask(){
        List<Task> taskList = taskService.findAllTask(2);
    }

    @Test
    public void findTrainingResultByOrder(){
        String order = "Ascending";
        int taskId = 0;
        int authorId = 2;
        List<TrainingResult> trainingResultList = trainingResultService.findTrainingResultByOrder(order, taskId, authorId);
        for(TrainingResult tr : trainingResultList){
            System.out.println(tr.toString());
        }
    }

}
