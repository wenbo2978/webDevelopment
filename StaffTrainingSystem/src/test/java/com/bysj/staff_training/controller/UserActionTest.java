package com.bysj.staff_training.controller;

import com.bysj.staff_training.pojo.User;
import com.bysj.staff_training.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/*
* user authority
* 0 : admin
* 1 : trainer
* 2: staff
*
*
*
*
*
* */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserActionTest {

    @Autowired
    UserService userService;

    @Test
    public void loginTest(){
        User user = new User();
        user.setUsername("snow");
        user.setPassword("123456");
        User user2 = userService.checkUser(user);
        System.out.println(user2.toString());
        //List<User> userList = userService.findAllUser();
    }

    @Test
    public void addUserTest(){
        User user = new User();
        user.setUsername("mark");
        user.setPassword("123456");
        user.setAuthority("2");
        userService.addUser(user);
    }

    @Test
    public void findAllUserTest(){
        List<User> userList = userService.findAllUser();
        for(User u : userList){
            System.out.println(u.toString());
        }
    }

    @Test
    public void uploadImage(){

    }
}
