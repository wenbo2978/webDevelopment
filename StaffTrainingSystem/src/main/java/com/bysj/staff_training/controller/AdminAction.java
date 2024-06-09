package com.bysj.staff_training.controller;

import com.bysj.staff_training.pojo.User;
import com.bysj.staff_training.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    UserService userService;

    //addUser
    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(HttpServletRequest request, HttpServletResponse response, User user){
        System.out.println("add user");
        return userService.addUser(user);
    }

    //updateUser
    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUser(int userId,String username,String password,String realname,String phone,String email,String authority){
        System.out.println("getUser:"+userId+"--"+username+"--"+password+"--"+realname+"--"+phone+"--"+email+"--"+authority);
        User user=new User();
        user.setUserid(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setRealname(realname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAuthority(authority);
        return userService.updateUser(user);
    }

    //deleteUser
    @RequestMapping(value="/deleteUser")
    @ResponseBody
    public int deleteUser(Integer userId){
        System.out.println("userId="+userId);

        return userService.deleteUser(userId);
    }

    //query all by page
    @RequestMapping("/queryAllByPage")
    @ResponseBody
    public Map<String, Object> queryAllByPageAjax(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//        System.out.println("----------page-----------");
        PageHelper.startPage(pn, 5);//紧接着的查询会被分页
        List<User> users =  userService.findAllUser();
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
        PageInfo page = new PageInfo(users, 5);
        //使用map集合存放对象信息，返回数据
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("pageInfo", page);
        return results;
    }

    //find user by id
    @RequestMapping("/findUserById")
    @ResponseBody
    public User findAllUser(Integer userId){
        return userService.findUserById(userId);
    }
}
