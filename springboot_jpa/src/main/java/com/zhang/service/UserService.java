package com.zhang.service;

import com.zhang.domain.User;

import java.util.List;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
public interface UserService {

    List<User> findUsers();

    User findUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

}
