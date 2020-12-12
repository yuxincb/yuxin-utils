package com.yuxin;

import com.yuxin.world.domain.User;
import com.yuxin.world.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ContainerTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void injectTest() {
        System.out.println(userMapper);
    }

    @Test
    void queryTest() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
