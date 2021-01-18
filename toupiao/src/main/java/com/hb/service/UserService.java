package com.hb.service;

import com.hb.pojo.User;

import java.util.List;

public interface UserService {
    User show(User user);
    //根据name查询
    User byUserName(String name);
    //注册
    int addUser(User user);
}
