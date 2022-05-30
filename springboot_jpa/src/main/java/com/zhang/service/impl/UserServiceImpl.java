package com.zhang.service.impl;

import com.zhang.dao.UserDao;
import com.zhang.domain.User;
import com.zhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUsers() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(Long id) {
        //Optional<User> optionalUser = userDao.findById(id);
        //User user = optionalUser.get();

        return userDao.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
