package com.bysj.staff_training.controller;


import com.bysj.staff_training.domain.ResultInfo;
import com.bysj.staff_training.pojo.*;
import com.bysj.staff_training.service.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffAction {

    @Autowired
    TrainingRecordService trainingRecordService;

    @Autowired
    TaskChoiceService taskChoiceService;

    @Autowired
    TaskEssayService taskEssayService;

    @Autowired
    TrainingResultService trainingResultService;


    @RequestMapping("/showTasks")
    @ResponseBody
    public List<TrainingRecord> showTasks(HttpServletRequest request, HttpServletResponse response){
        System.out.println("show task");
        User user = (User)request.getSession().getAttribute("user");
        System.out.println(user.toString());
        List<TrainingRecord> trainingRecordList = trainingRecordService.findAllTrainingRecordByStaff(user.getUserid());

        return trainingRecordList;
    }

    @RequestMapping("/findTaskStatus")
    @ResponseBody
    public boolean findTaskStatus(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(value = "trainingRId") Integer trainingRId){
        return trainingRecordService.ifTaskFinished(trainingRId);
    }

    @RequestMapping("/essayContent")
    @ResponseBody
    public List<TaskEssay> essayContent(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam(value = "trainingRId") Integer trainingRId){
        TrainingRecord trainingRecord = trainingRecordService.findTrainingRecordById(trainingRId);
        List<TaskEssay> essayList = taskEssayService.findAllEssayByTaskIdAndStaffId(trainingRecord);


        return essayList;
    }

    @RequestMapping("/choiceContent")
    @ResponseBody
    public List<TaskChoice> choiceContent(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam(value = "trainingRId") Integer trainingRId){
        TrainingRecord trainingRecord = trainingRecordService.findTrainingRecordById(trainingRId);
        List<TaskChoice> taskChoiceList = taskChoiceService.findAllChoiceByTaskIdAndStaffId(trainingRecord);
        return taskChoiceList;
    }

    @RequestMapping("/saveEssayAnswer")
    @ResponseBody
    public int saveEssayAnswer(HttpServletRequest request, HttpServletResponse response,
                               String answer,@RequestParam(value = "taskEssayId") Integer taskEssayId){
        if(!"null".equalsIgnoreCase(answer) && !answer.isEmpty()){
            System.out.println("answer: " + answer);
            TaskEssay taskEssay = new TaskEssay();
            taskEssay.setAnswer(answer);
            taskEssay.setTaskEssayId(taskEssayId);
            taskEssayService.saveEssayAnswer(taskEssay);
        }

        return 1;
    }

    @RequestMapping("/saveChoiceAnswer")
    @ResponseBody
    public int saveChoiceAnswer(HttpServletRequest request, HttpServletResponse response, String answer,
                                @RequestParam(value = "taskChoiceId") Integer taskChoiceId){
        if(!"null".equalsIgnoreCase(answer) && !answer.isEmpty()){
            TaskChoice taskChoice = new TaskChoice();
            taskChoice.setAnswer(answer);
            taskChoice.setTaskChoiceId(taskChoiceId);
            taskChoiceService.saveChoiceAnswer(taskChoice);
        }

        return 1;
    }

    @RequestMapping("/updateProcess")
    @ResponseBody
    public void updateProcess(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "trainingRId") Integer trainingRId){
        System.out.println("updateProcess");
        trainingRecordService.updateTrainingProcessing(trainingRId);

    }

    /*@RequestMapping(value="/updateTrainingRecord")
    @ResponseBody
    public int updateTrainingRecord(HttpServletRequest request, HttpServletResponse
            response,@RequestParam(value = "trainingRId") Integer trainingRId,
                                 String eTime) throws ParseException {

        return 0;
    }*/


    @RequestMapping("/finishEssay")
    @ResponseBody
    public void finishEssay(Integer taskEssayId){
        System.out.println("finish essay answer");
        taskEssayService.finishEssayAnswer(taskEssayId);

    }
    @RequestMapping("/finishChoice")
    @ResponseBody
    public void finishChoice(Integer taskChoiceId){
        System.out.println("finish choice answer");
        taskChoiceService.finishChoiceAnswer(taskChoiceId);
    }



    @RequestMapping("/finishTrainingRecord")
    @ResponseBody
    public void finishTrainingRecord(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "trainingRId") Integer trainingRId){
        System.out.println("Finish TrainingRId:" + trainingRId);
        trainingRecordService.finishTrainingRecord(trainingRId);

    }



    @RequestMapping("/findResult")
    @ResponseBody
    public List<TrainingResult> findResult(HttpServletRequest request, HttpServletResponse response){
        User user = (User)request.getSession().getAttribute("user");
        List<TrainingResult> resultList = trainingResultService.findAllTrainingResultByStaffId(user.getUserid());
        return resultList;
    }

    @RequestMapping("/findAdvice")
    @ResponseBody
    public TrainingResult findAdvice(HttpServletRequest request, HttpServletResponse response,Integer trainingResId){
        TrainingResult result = trainingResultService.findTrainingResultById(trainingResId);
        return result;
    }



    @RequestMapping("/submitAdvice")
    public String submitAdvice(HttpServletRequest request, HttpServletResponse response,
                             Integer trainingResId,String staffAdvice, String staffFeedBack){
        TrainingResult trainingResult = new TrainingResult();
        trainingResult.setStaffAdvice(staffAdvice);
        trainingResult.setTrainingResId(trainingResId);
        trainingResult.setStaffFeedBack(staffFeedBack);
        trainingResultService.submitFeedBack(trainingResult);
        return "staffEvaluate";
    }

}
