package com.zhang.service.impl;

import com.zhang.dao.UserMapper;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> findAll() {

        List<User> users = (List<User>) redisTemplate.boundValueOps("users").get();

        if(users == null){
            users = userMapper.selectAll();
            System.out.println("从mysql中查询的数据");
            redisTemplate.boundValueOps("users").set(users);
        }else{
            System.out.println("从redis中查询的数据");
        }

        return users;
    }
}
