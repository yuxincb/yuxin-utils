package com.yuxin.project.world.controller;

import com.yuxin.framework.web.controller.BaseController;
import com.yuxin.framework.web.domain.AjaxResult;
import com.yuxin.project.world.domain.User;
import com.yuxin.project.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController extends BaseController {

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
    public AjaxResult getUsers() {
        try {
            List<User> allUsers = userService.getAllUsers();
            return success("success", allUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fail();
    }

}
