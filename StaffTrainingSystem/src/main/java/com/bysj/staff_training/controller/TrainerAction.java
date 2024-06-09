package com.bysj.staff_training.controller;

import com.bysj.staff_training.pojo.*;
import com.bysj.staff_training.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.SynthesizedAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/trainer")
public class TrainerAction {

    List<Task> taskList = new ArrayList<>();
    List<TaskChoice> choiceList = new ArrayList<>();
    List<TaskEssay> essayList = new ArrayList<>();

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

    //find task by id
    @RequestMapping("/findTaskById")
    @ResponseBody
    public Task findTaskById(Integer taskId){

        return taskService.getTaskByTaskId(taskId);
    }

    @PostMapping("/addTask")
    public String addTask(HttpServletRequest request, HttpServletResponse response, @RequestParam("attachment") MultipartFile file) throws IOException, Exception {
        System.out.println("addTask");
        System.out.println(file);
        if (!file.isEmpty()) {
            String taskName = request.getParameter("taskName");
            String begin_Time = request.getParameter("begin_Time");
            String end_Time = request.getParameter("end_Time");
            String scope = request.getParameter("scope");
            String category = request.getParameter("category");
            String attachment = file.getOriginalFilename();
            Task task = new Task(taskName, scope, category, begin_Time, end_Time, attachment, 2);
            task.setIsPublished("unPublished");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            task.setAuthorId(user.getUserid());
            System.out.println(task.toString());
            taskService.addTask(task);
            //
            //mkService.insertMk(mk);

            /* do not upload file yet
            String url = "C:/Users/PC_chen/Desktop/bs/staff_training/src/main/resources/static/uploadmk/";
            url = url + accessory;
            file.transferTo(new File(url));
            */

            //List<Mk> mkList = mkService.findAllMkUnPublic(user);
            //System.out.println(mkList.size());

            //request.getSession().setAttribute("mkList", mkList);
        } else {
            System.out.print("empty file!!!\n");
        }
        return "taskSetting";
    }

    //updateUser
    @RequestMapping("/updateTask")
    @ResponseBody
    public String updateTask(HttpServletRequest request, HttpServletResponse response, @RequestParam("attachment") MultipartFile file) throws IOException, Exception{
        System.out.println("editTask");
        System.out.println(file);
        if (!file.isEmpty()) {
            Integer taskId = Integer.valueOf(request.getParameter("taskId"));
            String taskName = request.getParameter("taskName");
            String begin_Time = request.getParameter("begin_Time");
            String end_Time = request.getParameter("end_Time");
            String scope = request.getParameter("scope");
            String category = request.getParameter("category");
            String attachment = file.getOriginalFilename();
            Task task = new Task(taskId, taskName, scope, category, begin_Time, end_Time, attachment);
            task.setIsPublished("unPublished");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            task.setAuthorId(user.getUserid());
            System.out.println(task.toString());
            taskService.updateTask(task);
            //
            //mkService.insertMk(mk);

            /* do not upload file yet
            String url = "C:/Users/PC_chen/Desktop/bs/staff_training/src/main/resources/static/uploadmk/";
            url = url + accessory;
            file.transferTo(new File(url));
            */

            //List<Mk> mkList = mkService.findAllMkUnPublic(user);
            //System.out.println(mkList.size());

            //request.getSession().setAttribute("mkList", mkList);
        } else {
            System.out.print("empty file!!!\n");
        }
        return "taskSetting";
    }

    //deleteTask
    @RequestMapping(value="/deleteTask")
    @ResponseBody
    public int deleteUser(Integer taskId){
        System.out.println("taskId="+taskId);
        taskService.deleteTask(taskId);
        return 1;
    }

    //query all by page
    @RequestMapping("/queryAllByPage")
    @ResponseBody
    public Map<String, Object> queryAllByPageAjax(HttpServletRequest request, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        System.out.println("----------page-----------");
        PageHelper.startPage(pn, 5);//紧接着的查询会被分页
        User u = (User)request.getSession().getAttribute("user");
        System.out.println(u.getUserid());
        List<Task> tasks = taskService.findAllTaskByTrainer(u.getUserid());
        /*for(Task t : tasks){
            System.out.println(t.toString());
        }*/
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
        PageInfo page = new PageInfo(tasks, 5);
        //使用map集合存放对象信息，返回数据
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("pageInfo", page);
        return results;
    }


    @RequestMapping("/getTaskIdByUserId")
    @ResponseBody
    public List<Task> getTaskIdByUserId(HttpServletRequest request, HttpServletResponse response){
        System.out.println("get Task");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Task> tasks = taskService.findAllUnpublishedTaskByTrainer(user.getUserid());
        return tasks;
    }

    @RequestMapping("/addTaskChoice")
    @ResponseBody
    public int addTaskChoice(HttpServletRequest request, HttpServletResponse response){
        System.out.println("addTaskChoice");
        int taskId = Integer.valueOf(request.getParameter("taskId"));
        String taskQ = request.getParameter("taskQ");
        String taskChoiceA = request.getParameter("taskChoiceA");
        String taskChoiceB = request.getParameter("taskChoiceB");
        String taskChoiceC = request.getParameter("taskChoiceC");
        String taskChoiceD = request.getParameter("taskChoiceD");
        String correctAnswer = request.getParameter("correctAnswer");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        TaskChoice tc = new TaskChoice(taskId, user.getUserid(), taskQ, taskChoiceA, taskChoiceB, taskChoiceC,
                taskChoiceD, correctAnswer);
        System.out.println(tc.toString());
        taskChoiceService.addTaskChoice(tc);
        return 0;
    }

    @RequestMapping("/addTaskEssay")
    @ResponseBody
    public int addTaskEssay(HttpServletRequest request, HttpServletResponse response){
        System.out.println("addTaskEssay");
        int taskId = Integer.valueOf(request.getParameter("taskId"));
        String taskQ = request.getParameter("taskQ");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        TaskEssay taskEssay = new TaskEssay(taskId, user.getUserid(), taskQ);

        System.out.println(taskEssay.toString());
        taskEssayService.addTaskEssay(taskEssay);
        return 0;
    }

    @RequestMapping("/taskContent/{taskId}")
    public String taskContent(HttpServletRequest request, HttpServletResponse response,
                                   @PathVariable int taskId) throws IOException, Exception {
        System.out.println("taskContent" + taskId);
        Task task = taskService.getTaskByTaskId(taskId);
        List<TaskChoice> taskChoiceList = taskChoiceService.getAllChoiceByTaskId_Trainer(taskId);
        List<TaskEssay> taskEssayList = taskEssayService.getAllEssayByTaskId_Trainer(taskId);

        request.getSession().setAttribute("taskChoiceList", taskChoiceList);
        request.getSession().setAttribute("taskEssayList", taskEssayList);
        request.getSession().setAttribute("task", task);

        return "taskContent";
    }

    @RequestMapping("/taskChoiceDel/{taskChoiceId}")
    public String taskChoiceDel(HttpServletRequest request, HttpServletResponse response,
                                @PathVariable int taskChoiceId) throws IOException, Exception {
        System.out.println("Choice Delete" + taskChoiceId);
        taskChoiceService.deleteTaskChoice(taskChoiceId);
        Task task = (Task) request.getSession().getAttribute("task");
        int taskId = task.getTaskId();
        List<TaskChoice> taskChoiceList = taskChoiceService.getAllChoiceByTaskId_Trainer(taskId);
        request.getSession().setAttribute("taskChoiceList", taskChoiceList);


        return "taskContent";
    }

    @RequestMapping("/taskEssayDel/{taskEssayId}")
    public String taskEssayDel(HttpServletRequest request, HttpServletResponse response,
                                @PathVariable int taskEssayId) throws IOException, Exception {
        System.out.println("Essay Delete" + taskEssayId);
        taskEssayService.deleteTaskEssay(taskEssayId);
        Task task = (Task) request.getSession().getAttribute("task");
        int taskId = task.getTaskId();
        List<TaskEssay> taskEssayList = taskEssayService.getAllEssayByTaskId_Trainer(taskId);
        request.getSession().setAttribute("taskEssayList", taskEssayList);

        return "taskContent";
    }

    @RequestMapping("/getTaskChoiceByChoiceId")
    @ResponseBody
    public TaskChoice getTaskChoiceByChoiceId(HttpServletRequest request, HttpServletResponse response,
                                              @RequestParam(value = "taskChoiceId") int taskChoiceId){
        System.out.println("taskChoiceEdit Modal show:" + taskChoiceId);
        TaskChoice taskChoice = taskChoiceService.getChoiceById(taskChoiceId);
        return taskChoice;
    }

    @RequestMapping("/getTaskEssayByEssayId")
    @ResponseBody
    public TaskEssay getTaskEssayByEssayId(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam(value = "taskEssayId") int taskEssayId){
        System.out.println("taskEssayEdit Modal show:" + taskEssayId);
        TaskEssay taskEssay = taskEssayService.getEssayById(taskEssayId);
        return taskEssay;
    }

    @RequestMapping("/taskChoiceSaveEdit")
    public String taskChoiceSaveEdit(HttpServletRequest request, HttpServletResponse response){
        System.out.println("editTaskChoice");
        int taskChoiceId = Integer.valueOf(request.getParameter("taskChoiceId"));
        String taskQ = request.getParameter("taskQ");
        String taskChoiceA = request.getParameter("taskChoiceA");
        String taskChoiceB = request.getParameter("taskChoiceB");
        String taskChoiceC = request.getParameter("taskChoiceC");
        String taskChoiceD = request.getParameter("taskChoiceD");
        String correctAnswer = request.getParameter("correctAnswer");
        TaskChoice taskChoice = new TaskChoice(taskChoiceId, taskQ, taskChoiceA, taskChoiceB,
                taskChoiceC, taskChoiceD, correctAnswer);
        taskChoiceService.updateTaskChoice(taskChoice);
        Task task = (Task) request.getSession().getAttribute("task");
        int taskId = task.getTaskId();
        List<TaskChoice> taskChoiceList = taskChoiceService.getAllChoiceByTaskId_Trainer(taskId);
        request.getSession().setAttribute("taskChoiceList", taskChoiceList);
        return "taskContent";
    }

    @RequestMapping("/taskEssaySaveEdit")
    public String taskEssaySaveEdit(HttpServletRequest request, HttpServletResponse response){
        System.out.println("editTaskEssay");
        int taskEssayId = Integer.valueOf(request.getParameter("taskEssayId"));
        String taskQ = request.getParameter("taskQ");
        TaskEssay taskEssay = new TaskEssay(taskEssayId, taskQ);
        taskEssayService.updateTaskEssay(taskEssay);
        Task task = (Task) request.getSession().getAttribute("task");
        int taskId = task.getTaskId();
        List<TaskEssay> taskEssayList = taskEssayService.getAllEssayByTaskId_Trainer(taskId);
        request.getSession().setAttribute("taskEssayList", taskEssayList);
        return "taskContent";
    }

    @RequestMapping("/taskPublish")
    @ResponseBody
    public int taskPublish(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "taskId") int taskId){
        System.out.println("publish task:" + taskId);
        User u = (User)request.getSession().getAttribute("user");
        taskService.publishTask(taskId, u.getUserid());
        return 1;
    }

    @RequestMapping("/getTrainingProcess")
    public String getTrainingProcess(HttpServletRequest request, HttpServletResponse response){
        User user = (User)request.getSession().getAttribute("user");
        List<TotalTrainingRecord> totalList = taskService.findTotalTrainingRecord(user.getUserid());

        request.getSession().setAttribute("totalRecord", totalList);
        return "trainingProcessing";
    }

    @RequestMapping("/recordDetail/{taskId}")
    public String recordDetail(HttpServletRequest request, HttpServletResponse response,
                               @PathVariable int taskId) throws IOException, Exception {
        System.out.println("InquireDetailId:" + taskId);
        List<TrainingRecord> recordList = trainingRecordService.findTrainingRecordByTaskId(taskId);
        request.getSession().setAttribute("recordList", recordList);
        return "recordDetail";
    }

    @RequestMapping("/recordStaffDetail/{trainingRId}")
    public String recordStaffDetail(HttpServletRequest request, HttpServletResponse response,
                                    @PathVariable int trainingRId) throws IOException, Exception {
        System.out.println("InquireStaffDetailId:" + trainingRId);

        TrainingRecord trainingRecord = trainingRecordService.findTrainingRecordById(trainingRId);
        List<String> res = trainingRecordService.getOperationAccess(trainingRecord);
        String due = res.get(0);
        String ifCanMakeEvaluate = res.get(1);
        System.out.println(due + ", " + ifCanMakeEvaluate);
        List<TaskChoice> taskChoiceList = taskChoiceService.findAllChoiceByTaskIdAndStaffId(trainingRecord);
        List<TaskEssay> taskEssayList = taskEssayService.findAllEssayByTaskIdAndStaffId(trainingRecord);


        //setAttribute();
        request.getSession().setAttribute("due",due);
        request.getSession().setAttribute("staffChoiceList", taskChoiceList);
        request.getSession().setAttribute("staffEssayList", taskEssayList);
        request.getSession().setAttribute("trainingRecord", trainingRecord);
        request.getSession().setAttribute("ifCanMakeEvaluate", ifCanMakeEvaluate);

        return "recordStaffDetail";
    }


    @RequestMapping("/setEssayScore")
    @ResponseBody
    public int setEssayScore(HttpServletRequest request, HttpServletResponse response){
        int score = Integer.valueOf(request.getParameter("score"));
        int taskEssayId = Integer.valueOf(request.getParameter("taskEssayId"));
        TaskEssay essay = new TaskEssay();
        essay.setTaskEssayId(taskEssayId);
        essay.setScore(score);
        taskEssayService.updateEssayScore(essay);
        return score;
    }

    @RequestMapping("/submitEvaluation")
    public String submitEvaluation(HttpServletRequest request, HttpServletResponse response){
        TrainingRecord trainingRecord = new TrainingRecord();
        trainingRecord.setIsFinished("Finished");
        trainingRecord.setIsEvaluated("Evaluated");
        request.getSession().setAttribute("trainingRecord", trainingRecord);
        int trainingRId = Integer.valueOf(request.getParameter("trainingRId"));
        String feedBack = request.getParameter("feedBack");
        trainingRecordService.submitEvaluation(trainingRId, feedBack);
        return "recordStaffDetail";
    }

    @RequestMapping("/submitDue")
    public String submitDue(HttpServletRequest request, HttpServletResponse response){
        TrainingRecord trainingRecord = new TrainingRecord();
        trainingRecord.setIsFinished("Finished");
        trainingRecord.setIsEvaluated("Evaluated");
        request.getSession().setAttribute("trainingRecord", trainingRecord);
        int trainingRId = Integer.valueOf(request.getParameter("trainingRId"));
        String feedBack = request.getParameter("feedBack");
        trainingRecordService.submitDue(trainingRId, feedBack);
        return "recordStaffDetail";
    }

    @RequestMapping("/toListResult")
    public String toListResult(HttpServletRequest request, HttpServletResponse response)
            throws IOException, Exception{
        return "toResultList";
    }

    @RequestMapping("/getTaskIdForRes")
    @ResponseBody
    public List<Task> getTaskIdForRes(HttpServletRequest request, HttpServletResponse response){
        User user = (User)request.getSession().getAttribute("user");
        List<Task> list = taskService.findAllTask(user.getUserid());
        return list;
    }

    @RequestMapping("/listResultByOrder")
    @ResponseBody
    public List<TrainingResult> listResultByOrder(HttpServletRequest request, HttpServletResponse response,
                                                  @RequestParam("data") String data){

        String[] dataArray = data.split(" ");
        System.out.println(dataArray[0] + ", " + dataArray[1]);
        User user = (User)request.getSession().getAttribute("user");
        List<TrainingResult> trainingResultList =
                trainingResultService.findTrainingResultByOrder(dataArray[0], Integer.valueOf(dataArray[1]), user.getUserid());
        return trainingResultList;
    }
    /*
    分割线
     */

    @RequestMapping("/toResultFeedBack")
    public String toResultFeedBack(HttpServletRequest request, HttpServletResponse response){
        List<TrainingResult> trainingResultList = new ArrayList<>();
        for(int i = 0; i < 5; i ++){
            TrainingResult tr = new TrainingResult();
            tr.setTrainingResId(i);
            tr.setStaffName("user0" + i);
            tr.setStaffFeedBack("First Essay Evaluation is Wrong.");
            tr.setTaskName("task0" + i);
            trainingResultList.add(tr);
        }
        request.getSession().setAttribute("trainingResList", trainingResultList);
        return "toResultFeedBack";
    }

    @RequestMapping("/evaluationModification/{trainingResId}")
    public String evaluationModification(HttpServletRequest request, HttpServletResponse response,
                                         @PathVariable int trainingResId){
        System.out.println("trainingResId:" + trainingResId);

        //get TrainingRecord By staffId and taskId
        TrainingRecord trainingRecord = new TrainingRecord();
        trainingRecord.setIsFinished("Finished");
        trainingRecord.setIsEvaluated("unEvaluated");



        //get staffId and taskId by TrainingRecord



        //get TaskChoice and TaskEssay by staffId and taskId
        List<TaskChoice> taskChoiceList = new ArrayList<>();
        List<TaskEssay> taskEssayList = new ArrayList<>();

        for(int i = 0; i < 3; i ++){
            TaskChoice tc = new TaskChoice(1, 2, 3, "Quest_" + i, "SelectionA",
                    "SelectionB", "SelectionC", "SelectionD", "A", "unFinished");
            tc.setAnswer("A");

            taskChoiceList.add(tc);
        }

        for(int i = 0; i < 3; i ++){
            TaskEssay te = new TaskEssay(1, 2, 3, "Quest_" + i, "Finished", 0);
            te.setTaskEssayId(i);
            taskEssayList.add(te);
        }


        //judge if it is due
        String due = "overDue";
        String ifCanMakeEvaluate = "can submit";


        //setAttribute();
        request.getSession().setAttribute("due",due);
        request.getSession().setAttribute("staffChoiceList", taskChoiceList);
        request.getSession().setAttribute("staffEssayList", taskEssayList);
        request.getSession().setAttribute("trainingRecord", trainingRecord);
        request.getSession().setAttribute("ifCanMakeEvaluate", ifCanMakeEvaluate);
        return "recordStaffDetail";
    }
}
