package com.yuxin.world.service.impl;

import com.yuxin.world.domain.User;
import com.yuxin.world.mapper.UserMapper;
import com.yuxin.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

}
