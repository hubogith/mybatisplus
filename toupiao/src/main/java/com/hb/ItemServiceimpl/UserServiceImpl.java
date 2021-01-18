package com.hb.ItemServiceimpl;

import com.hb.mapper.UserMapper;
import com.hb.pojo.User;
import com.hb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User show(User user) {
        return userMapper.show(user);
    }

    @Override
    public User byUserName(String name) {
        return userMapper.byUserName(name);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
