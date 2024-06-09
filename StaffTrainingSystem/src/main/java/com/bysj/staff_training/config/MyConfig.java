package com.bysj.staff_training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/test.html").setViewName("test");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");      //登录界面
        registry.addViewController("/userList.html").setViewName("userList");      //用户信息管理界面
        registry.addViewController("/trainer_index.html").setViewName("trainer_index");      //培训师端跳转
        registry.addViewController("/taskSetting.html").setViewName("taskSetting");      //培训设置界面
        registry.addViewController("/taskContent.html").setViewName("taskContent");      //配信内容详情界面
        registry.addViewController("/trainingProcessing.html").setViewName("trainingProcessing"); //培训师查看整体进度
        registry.addViewController("recordDetail.html").setViewName("recordDetail"); //培训师查看单独task进度
        registry.addViewController("recordStaffDetail.html").setViewName("recordStaffDetail"); //培训师查看单独个人进度
        registry.addViewController("/toResultList.html").setViewName("toResultList"); //培训师查看结果
        registry.addViewController("/toResultFeedBack.html").setViewName("toResultFeedBack");//人事部查看评价反馈界面
        registry.addViewController("/personInfo.html").setViewName("personInfo");      //个人信息完善界面
        registry.addViewController("/staff_index.html").setViewName("staff_index");      //普通员工端跳转
        registry.addViewController("enterTask.html").setViewName("enterTask");         //进入培训
        registry.addViewController("/staffEvaluate.html").setViewName("staffEvaluate");      //员工培训结果评价界面
        registry.addViewController("/staffAdvice.html").setViewName("staffAdvice");      //员工意见界面

        /*
        //即将删除界面
        registry.addViewController("/rsb_index.html").setViewName("rsb_index");      //人事部端跳转
        registry.addViewController("/trainningSet.html").setViewName("trainningSet");      //培训设置界面
        registry.addViewController("/taskOperate.html").setViewName("taskOperate");
        registry.addViewController("/scanMkCondition.html").setViewName("scanMkCondition");
        registry.addViewController("/rsbScanResult.html").setViewName("rsbScanResult");
        registry.addViewController("/resultReturn.html").setViewName("resultReturn");//人事部查看评价反馈界面
        registry.addViewController("/resultReturnDetail.html").setViewName("resultReturnDetail");//人事部查看评价反馈详情界面

        //未修改的界面
        registry.addViewController("/admin_index.html").setViewName("admin_index");      //管理员端跳转

        registry.addViewController("/deptgg_index.html").setViewName("deptgg_index");      //公司高管端跳转

        registry.addViewController("/rsbInfo.html").setViewName("rsbInfo");      //个人信息完善界面
        registry.addViewController("/deptggInfo.html").setViewName("deptggInfo");      //个人信息完善界面
        registry.addViewController("/addTaskContent.html").setViewName("addTaskContent");      //培训任务分配界面


        registry.addViewController("/mkOperate.html").setViewName("mkOperate");

        registry.addViewController("/mkEdit.html").setViewName("mkEdit");
        registry.addViewController("/task_rEdit.html").setViewName("task_rEdit");
        registry.addViewController("/task_weEdit.html").setViewName("task_weEdit");
        registry.addViewController("/task_wdEdit.html").setViewName("task_wdEdit");

        registry.addViewController("recordStaffDetail.html").setViewName("recordStaffDetail");
        registry.addViewController("/resultCheck.html").setViewName("resultCheck");
        registry.addViewController("/addBaseMk.html").setViewName("addBaseMk");
        registry.addViewController("/mkDept.html").setViewName("mkDept");
        registry.addViewController("/baseMkOperate.html").setViewName("baseMkOperate");
        registry.addViewController("/otherMkOperate.html").setViewName("otherMkOperate");
        registry.addViewController("/scanBaseMk.html").setViewName("scanBaseMk");
        registry.addViewController("/recordBaseDetail.html").setViewName("recordBaseDetail");
        registry.addViewController("/scanMkConditionByDept.html").setViewName("scanMkConditionByDept");
        registry.addViewController("/rsbMk.html").setViewName("rsbMk");
        registry.addViewController("/resultMkDetail.html").setViewName("resultMkDetail");
        registry.addViewController("/resultPDetail.html").setViewName("resultPDetail");

        registry.addViewController("/resultReturnPDetail.html").setViewName("resultReturnPDetail");//人事部查看评价反馈个人详情界面
        registry.addViewController("/MKSet_ReadMaterial.html").setViewName("MKSet_ReadMaterial");      //阅读材料设置
        registry.addViewController("/MKSet_SubItem.html").setViewName("MKSet_SubItem");      //主观题设置
        registry.addViewController("/MKSet_ObjItem.html").setViewName("MKSet_ObjItem");      //客观题设置



        registry.addViewController("/processDetail.html").setViewName("processDetail");      //员工培训进度详情界面


        //已删除
        registry.addViewController("/trainingRecord.html").setViewName("trainingRecord");      //员工培训记录界面
        registry.addViewController("/followProcess.html").setViewName("followProcess");      //跟踪员工培训进度界面
        registry.addViewController("/addTaskContent_R.html").setViewName("addTaskContent_R");
        registry.addViewController("/addTaskContent_WE.html").setViewName("addTaskContent_WE");
        registry.addViewController("/addTaskContent_WD.html").setViewName("addTaskContent_WD");

         */
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**")
                .addResourceLocations("file:/path/to/static/");
    }




}
