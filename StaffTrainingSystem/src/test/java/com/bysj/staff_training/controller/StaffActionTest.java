package com.bysj.staff_training.controller;

import com.bysj.staff_training.pojo.TaskChoice;
import com.bysj.staff_training.pojo.TaskEssay;
import com.bysj.staff_training.pojo.TrainingRecord;
import com.bysj.staff_training.pojo.TrainingResult;
import com.bysj.staff_training.service.TaskChoiceService;
import com.bysj.staff_training.service.TaskEssayService;
import com.bysj.staff_training.service.TrainingRecordService;
import com.bysj.staff_training.service.TrainingResultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StaffActionTest {

    @Autowired
    TrainingRecordService trainingRecordService;

    @Autowired
    TaskChoiceService taskChoiceService;

    @Autowired
    TaskEssayService taskEssayService;

    @Autowired
    TrainingResultService trainingResultService;

    @Test
    public void showTasksByStaff(){
        int staffId = 11;
        List<TrainingRecord> trainingRecordList = trainingRecordService.findAllTrainingRecordByStaff(staffId);
        for(TrainingRecord trainingRecord : trainingRecordList)
            System.out.println(trainingRecord.toString());
    }

    @Test
    public void findTaskStatus(){
        int trainingRId = 1;
        boolean res = trainingRecordService.ifTaskFinished(trainingRId);
    }

    @Test
    public void findChoiceContentByStaff(){
        int trainingRId = 1;
        TrainingRecord trainingRecord = trainingRecordService.findTrainingRecordById(trainingRId);
        List<TaskChoice> taskChoiceList = taskChoiceService.findAllChoiceByTaskIdAndStaffId(trainingRecord);
    }

    @Test
    public void findEssayContentByStaff(){
        int trainingRId = 1;
        TrainingRecord trainingRecord = trainingRecordService.findTrainingRecordById(trainingRId);
        List<TaskEssay> essayList = taskEssayService.findAllEssayByTaskIdAndStaffId(trainingRecord);
    }

    @Test
    public void saveChoiceAnswer(){
        String answer = "A";
        int taskChoiceId = 12;
        TaskChoice taskChoice = new TaskChoice();
        taskChoice.setAnswer(answer);
        taskChoice.setTaskChoiceId(taskChoiceId);
        taskChoiceService.saveChoiceAnswer(taskChoice);
    }

    @Test
    public void saveEssayAnswer(){
        String answer = "this is a test answer";
        int taskEssayId = 12;
        TaskEssay taskEssay = new TaskEssay();
        taskEssay.setAnswer(answer);
        taskEssay.setTaskEssayId(taskEssayId);
        taskEssayService.saveEssayAnswer(taskEssay);
    }

    @Test
    public void updateProcess(){
        int trainingRId = 5;
        trainingRecordService.updateTrainingProcessing(trainingRId);
    }

    @Test
    public void finishTaskChoice(){
        int taskChoiceId = 11;
        taskChoiceService.finishChoiceAnswer(taskChoiceId);
    }

    @Test
    public void finishTaskEssay(){
        int taskEssayId = 12;
        taskEssayService.finishEssayAnswer(taskEssayId);
    }

    @Test
    public void finishTask(){
        int trainingRId = 5;
        trainingRecordService.finishTrainingRecord(trainingRId);
    }

    @Test
    public void findResult(){
        int staffId = 11;
        List<TrainingResult> trainingResultList = trainingResultService.findAllTrainingResultByStaffId(staffId);
    }

    @Test
    public void findResultById(){
        int trainingResId = 1;
        TrainingResult trainingResult = trainingResultService.findTrainingResultById(trainingResId);
    }

    @Test
    public void submitFeedBack(){
        TrainingResult trainingResult = new TrainingResult();
        trainingResult.setStaffAdvice("Agree");
        trainingResult.setTrainingResId(1);
        trainingResult.setStaffFeedBack("");
        trainingResultService.submitFeedBack(trainingResult);
    }

}
