package com.yuxin;

import com.yuxin.project.world.domain.User;
import com.yuxin.project.world.mapper.UserMapper;
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
        List<User> users1 = userMapper.selectList(null);
        List<User> users2 = userMapper.selectUsers();
        System.out.println(users1);
        System.out.println(users2);
    }

}
