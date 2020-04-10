package com.animal.animal.community.Dao;

import com.animal.animal.community.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
//基础的增删改查操作
public interface UserDAO extends JpaRepository<User,Integer> {
        User findByUsername(String username);
        User getByUsernameAndPassword(String username,String password);
    }

