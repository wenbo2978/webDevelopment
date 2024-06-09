package com.bysj.staff_training.controller;


import com.bysj.staff_training.domain.ResultInfo;
import com.bysj.staff_training.pojo.User;
import com.bysj.staff_training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    UserService userService;


    //login
    @RequestMapping("/user_login")
    @ResponseBody
    public ResultInfo user_login(HttpServletRequest request,HttpServletResponse response,User user)throws IOException,Exception {
        System.out.println(user);
        User u = userService.checkUser(user);
        ResultInfo info = userService.loginPage(u);
        if(u!=null){
            request.getSession().setAttribute("user", u);
        }

        return info;
    }

    //findAllUser
    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping("/findAllStaff")
    @ResponseBody
    public List<User> findAllStaff(){
        return userService.findAllStaff();
    }






    /*@RequestMapping("/queryRecordByPage")
    @ResponseBody
    public Map<String, Object> queryRecordByPageAjax(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam(value = "staffid", defaultValue = "1") Integer staffid) {
        PageHelper.startPage(pn, 5);//紧接着的查询会被分页
        List<Training_Record> training_records = training_recordService.findRecordByStaffId(staffid);
//        for(int i=0;i<training_records.size();i++){
//            System.out.println("record："+training_records.get(i).toString());
//        }
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
        PageInfo page = new PageInfo(training_records, 5);
        //使用map集合存放对象信息，返回数据
        Map<String, Object> results = new HashMap<String, Object>();

        results.put("pageInfo", page);
        return results;
    }*/


    @PostMapping("/personInfoedit")
    public String personInfo_edit(HttpServletRequest request, HttpServletResponse response, @RequestParam("picture") MultipartFile file) throws IOException,Exception {

        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");



        System.out.println(file);

        String url="";
        String picurl="";
        String str = "";

        if(!file.isEmpty()){

            String filePath="/uploadimg/";
            //System.out.println("file path:");

            String fileName=file.getOriginalFilename();
            picurl=fileName;
            url = filePath;
            file.transferTo(new File(url));
            System.out.println("end");

            String realname=request.getParameter("realname");
            String phone=request.getParameter("phone");
            String email=request.getParameter("email");
            System.out.println("realname:" + realname + ",Phone:" + phone + ",Email:" + email + ",Pic_url:" + picurl);

            User newuser = new User();
            newuser.setUserid(user.getUserid());
            newuser.setUsername(user.getUsername());
            newuser.setRealname(realname);
            newuser.setPhone(phone);
            newuser.setEmail(email);
            newuser.setPicture(picurl);
            newuser.setAuthority(user.getAuthority());
            //System.out.println("username:" + newuser.getUsername() + ",Authority:" + newuser.getAuthority() + ",Email:" + newuser.getPassword());
            userService.updateStaffInfo(newuser);
            request.getSession().setAttribute("user", newuser);
            str="success";
        }
        else {
            str="fail";
        }
        return "personInfo";
    }
}
