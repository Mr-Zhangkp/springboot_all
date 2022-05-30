package com.zhang.controller;

import com.zhang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public List<User> findAll(){
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setUsername("小龙女");
        user1.setAge(18);
        user1.setSex("女");

        users.add(user1);

        User user2 = new User();
        user2.setUsername("尹志平");
        user2.setAge(40);
        user2.setSex("男");

        users.add(user2);

        return users;
    }
}
