package com.hb.pojo;

import java.io.Serializable;

public class User implements Serializable {
    //`user_id``user_name``user_pwd``user_status`
    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer userStatus;

    public User() {
    }

    public User(Integer userId, String userName, String userPwd, Integer userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userStatus = userStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
