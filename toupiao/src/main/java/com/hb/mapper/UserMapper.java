package com.hb.mapper;

import com.hb.pojo.User;

public interface UserMapper {
    //登录
    User show(User user);
    //用户名验证
    User byUserName(String name);
    //用户注册
    int addUser(User user);
}
