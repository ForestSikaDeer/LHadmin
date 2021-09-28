package com.jz.service.user.impl;

import com.jz.mapper.user.UserMapper;
import com.jz.pojo.User;
import com.jz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String userName,String userPassword) {
        return userMapper.login(userName,userPassword);
    }
}
