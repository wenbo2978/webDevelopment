package com.bysj.staff_training.dao;

import com.bysj.staff_training.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userMapper")

public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByUsername(String username);

    Object checkAdmin(User user);   //验证管理员身份

    Object checkStaff(User user);   //验证普通员工身份

    Object checkRsb(User user);     //验证人事部身份

    Object checkDeptgg(User user);     //验证公司高管身份

    int updateStaffInfo(User user);  //更新员工个人信息

    int updateRsbInfo(User user);     //更新人事部个人信息

    int updateDeptggInfo(User user);

    List<User> findAllUser(); //查询所有用户

    List<User> findUserByAuthority(String authority);

    int addUser(User user); //新增用户

    User findUserById(int userid);

    int updateMark(int userId);

    int deleteUser(int userId);//删除用户

    int updateUser(User user);//编辑用户

    List<User> findAllStaff();//查询所有普通员工

    User checkUser(User user);
}