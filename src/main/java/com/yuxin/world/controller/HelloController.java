package com.yuxin.world.controller;

import com.yuxin.world.domain.User;
import com.yuxin.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        return "hello world";
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
        return allUsers;
    }

}
