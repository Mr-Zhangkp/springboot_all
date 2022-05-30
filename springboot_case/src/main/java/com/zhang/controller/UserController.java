package com.zhang.controller;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public Result findAll(){
        List<User> users = userService.findAll();

        return Result.ok(users);
    }
}
