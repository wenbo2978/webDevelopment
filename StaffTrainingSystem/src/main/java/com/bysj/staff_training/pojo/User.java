package com.bysj.staff_training.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int userid;
    private String username;

    private String password;

    private String realname;

    private int mark;

    private String phone;

    private String email;

    private String picture;

    private String authority;

    private static final long serialVersionUID = 1L;

    public User(String username, String password, String realname,int mark,String phone,String email, String picture,String authority) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.mark = mark;
        this.phone = phone;
        this.email = email;
        this.picture = picture;
        this.authority = authority;
    }

    public User(int userid, String username, String password, String realname, String phone, String email, String authority) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.authority = authority;
    }

    public User() {
    }

    public int getUserid(){
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMark(){
        return mark;
    }

    public void setMark(int mark){
        this.mark = mark;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", mark=" + mark +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                ", authority=" + authority +
                '}';
    }
}