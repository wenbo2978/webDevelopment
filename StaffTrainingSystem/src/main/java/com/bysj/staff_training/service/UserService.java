package com.bysj.staff_training.service;

import com.bysj.staff_training.domain.ResultInfo;
import com.bysj.staff_training.pojo.User;

import java.util.List;

public interface UserService {
    public User findUserByUsername(String username);
    public int updateStaffInfo(User user);
    public int updateDeptggInfo(User user);
    public int updateRsbInfo(User user);
    public List<User> findAllUser();
    public List<User> findUserByAuthority(String authority);
    public int addUser(User user);
    public User findUserById(int userid);
    public int updateMark(int userId);
    int deleteUser(int userId);
    int updateUser(User user);
    List<User> findAllStaff();
    User checkUser(User user);
    ResultInfo loginPage(User user);

}
