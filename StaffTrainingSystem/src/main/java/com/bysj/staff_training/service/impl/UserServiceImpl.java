package com.bysj.staff_training.service.impl;

import com.bysj.staff_training.dao.UserMapper;
import com.bysj.staff_training.domain.ResultInfo;
import com.bysj.staff_training.pojo.User;
import com.bysj.staff_training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;


    @Override
    public User checkUser(User user){
        return userMapper.checkUser(user);
    }
    @Override
    public List<User> findUserByAuthority(String authority){
        return userMapper.findUserByAuthority(authority);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }



    @Override
    public int updateStaffInfo(User user) {

        return userMapper.updateStaffInfo(user);
    }

    @Override
    public int updateRsbInfo(User user) {

        return userMapper.updateRsbInfo(user);
    }

    @Override
    public int updateDeptggInfo(User user) {

        return userMapper.updateDeptggInfo(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User findUserById(int userid){
        return userMapper.findUserById(userid);
    }

    public int updateMark(int userId){
        return userMapper.updateMark(userId);
    }

    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> findAllStaff() {
        return userMapper.findAllStaff();
    }

    @Override
    public ResultInfo loginPage(User u){
        ResultInfo info = new ResultInfo();
        if(u!=null){
            info.setFlag(true);
            //System.out.println("User's authority: " + u.getAuthority());
            if(u.getAuthority().equals("Trainer")){
                System.out.println("trainer login");
                info.setAuthority("/trainer_index.html");

            }else if(u.getAuthority().equals("HR")){
                /*info.setAuthority("/deptgg_index.html");
                request.getSession().setAttribute("user", u);
                System.out.println(u.toString());
                List<Mk> mkList = mkService.findAllMkUnPublicByDept(u);
                System.out.println(mkList.size());
                List<Mk> deptmkList = mkService.findAllMkUnPublic(u);
                request.getSession().setAttribute("mkList", mkList);
                request.getSession().setAttribute("deptmkList", deptmkList);

                 */
            }else if(u.getAuthority().equals("Staff")){
                //go to staff's page
                info.setAuthority("/staff_index.html");

            }else if(u.getAuthority().equals("Administrator")){
                //go to administrator's page
                info.setAuthority("/admin_index.html");
            }
        }else {
            System.out.println("error");
            info.setFlag(false);
            info.setErrorMsg("Error Username or Password!!");
        }

        return info;
    }
}
