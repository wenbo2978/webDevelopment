package com.bysj.staff_training.service.impl;

import com.bysj.staff_training.dao.TrainingRecordMapper;
import com.bysj.staff_training.pojo.TaskChoice;
import com.bysj.staff_training.pojo.TaskEssay;
import com.bysj.staff_training.pojo.TrainingRecord;
import com.bysj.staff_training.pojo.TrainingResult;
import com.bysj.staff_training.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainingRecordServiceImpl implements TrainingRecordService {

    @Autowired
    TrainingRecordMapper trainingRecordMapper;

    @Autowired
    TaskChoiceService taskChoiceService;

    @Autowired
    TaskEssayService taskEssayService;

    @Autowired
    TrainingResultService trainingResultService;

    @Autowired
    UserService userService;

    @Override
    public int addTrainingRecord(TrainingRecord trainingRecord) {
        return trainingRecordMapper.addTrainingRecord(trainingRecord);
    }

    @Override
    public List<TrainingRecord> findTrainingRecordByTaskId(int taskId) {
        return trainingRecordMapper.findTrainingRecordByTaskId(taskId);
    }

    @Override
    public TrainingRecord findTrainingRecordById(int trainingRId) {
        return trainingRecordMapper.findTrainingRecordById(trainingRId);
    }

    @Override
    public List<String> getOperationAccess(TrainingRecord trainingRecord) {
        List<String> res = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(simpleDateFormat.format(date));
        /*System.out.println(simpleDateFormat.format(date).toString().compareTo("2024-06-07"));
        System.out.println(simpleDateFormat.format(date).toString().compareTo("2024-06-06"));
        System.out.println(simpleDateFormat.format(date).toString().compareTo("2024-06-05"));*/
        if(trainingRecord.getIsFinished().equals("Finished")){
            res.add("unDue");
            res.add("can submit");
        }else{
            if(simpleDateFormat.format(date).toString().compareTo(trainingRecord.getEnd_Time()) >= 1){
                //overDue
                res.add("OverDue");
                res.add("can submit");
            }else{
                //unDue, unFinished
                res.add("unDue");
                res.add("cannot submit");
            }

        }
        return res;
    }

    @Override
    public List<TrainingRecord> findAllTrainingRecordByStaff(int staffId) {
        return trainingRecordMapper.findAllTrainingRecordByStaff(staffId);
    }

    @Override
    public boolean ifTaskFinished(int trainingRId) {
        TrainingRecord trainingRecord = trainingRecordMapper.findTrainingRecordById(trainingRId);
        return trainingRecord.getIsFinished().equals("Finished");
    }

    @Override
    public int updateTrainingProcessing(int trainingRId) {
        TrainingRecord trainingRecord = trainingRecordMapper.findTrainingRecordById(trainingRId);
        List<TaskChoice> taskChoiceList = taskChoiceService.findAllChoiceByTaskIdAndStaffId(trainingRecord);
        List<TaskEssay> taskEssayList = taskEssayService.findAllEssayByTaskIdAndStaffId(trainingRecord);
        int total = taskEssayList.size() + taskChoiceList.size();
        int finishedAmount = 0;
        for(TaskChoice taskChoice : taskChoiceList){
            if(taskChoice.getIsFinished().equals("Finished"))
                finishedAmount ++;
        }
        for(TaskEssay taskEssay : taskEssayList)
            if(taskEssay.getIsFinished().equals("Finished"))
                finishedAmount ++;
        double process = finishedAmount * 1.0 / total;
        process = process * 100;

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        trainingRecord.setProcess(process);
        trainingRecord.setLastOperation_Time(simpleDateFormat.format(date));
        trainingRecordMapper.updateTrainingProcessing(trainingRecord);

        return 1;
    }

    @Override
    public int finishTrainingRecord(int trainingRId) {
        return trainingRecordMapper.finishTrainingRecord(trainingRId);
    }

    @Override
    public int submitEvaluation(int trainingRId, String feedBack) {
        //update trainingRecord
        TrainingRecord trainingRecord = trainingRecordMapper.findTrainingRecordById(trainingRId);
        trainingRecord.setFeedBack(feedBack);
        trainingRecord.setIsEvaluated("Evaluated");
        trainingRecordMapper.submitEvaluation(trainingRecord);
        //generate trainingResult
        //TrainingResult trainingResult = new TrainingResult();
        List<TaskEssay> taskEssayList = taskEssayService.findAllEssayByTaskIdAndStaffId(trainingRecord);
        List<TaskChoice> taskChoiceList = taskChoiceService.findAllChoiceByTaskIdAndStaffId(trainingRecord);
        int totalScore = 0;
        int choiceScore = 0;
        int essayScore = 0;
        for(TaskEssay te : taskEssayList){
            essayScore += te.getScore();
        }
        for(TaskChoice tc : taskChoiceList){
            if(tc != null && tc.getIsCorrect() != null && tc.getIsCorrect().equals("correct"))
                choiceScore += 5;
        }
        totalScore = essayScore + choiceScore;
        TrainingResult trainingResult = new TrainingResult(trainingRecord.getTaskId(), trainingRecord.getTaskName(),
                choiceScore, essayScore, totalScore, trainingRecord.getAuthorId(), trainingRecord.getStaffId(),
                trainingRecord.getStaffName(), feedBack);
        trainingResultService.addTrainingResult(trainingResult);

        return 1;
    }

    @Override
    public int submitDue(int trainingRId, String feedBack){
        //update trainingRecord
        TrainingRecord trainingRecord = trainingRecordMapper.findTrainingRecordById(trainingRId);
        trainingRecord.setFeedBack(feedBack);
        trainingRecord.setIsEvaluated("Evaluated");
        trainingRecordMapper.submitEvaluation(trainingRecord);
        //generate trainingResult
        //TrainingResult trainingResult = new TrainingResult();
        List<TaskEssay> taskEssayList = taskEssayService.findAllEssayByTaskIdAndStaffId(trainingRecord);
        List<TaskChoice> taskChoiceList = taskChoiceService.findAllChoiceByTaskIdAndStaffId(trainingRecord);
        int totalScore = 0;
        int choiceScore = 0;
        int essayScore = 0;
        for(TaskEssay te : taskEssayList){
            essayScore += te.getScore();
        }
        for(TaskChoice tc : taskChoiceList){
            if(tc != null && tc.getIsCorrect() != null && tc.getIsCorrect().equals("correct"))
                choiceScore += 5;
        }
        totalScore = essayScore + choiceScore;
        TrainingResult trainingResult = new TrainingResult(trainingRecord.getTaskId(), trainingRecord.getTaskName(),
                choiceScore, essayScore, totalScore, trainingRecord.getAuthorId(), trainingRecord.getStaffId(),
                trainingRecord.getStaffName(), feedBack);
        trainingResultService.addTrainingResult(trainingResult);
        userService.updateMark(trainingRecord.getStaffId());

        return 1;
    }


}
