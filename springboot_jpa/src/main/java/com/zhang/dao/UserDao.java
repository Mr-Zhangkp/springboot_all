package com.zhang.dao;

import com.zhang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
public interface UserDao extends JpaRepository<User,Long> {
}
