package com.animal.animal.community.service;

import com.animal.animal.community.Dao.UserDAO;
import com.animal.animal.community.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//二次分装Dao

@Service
public class UserService {
     @Autowired
    UserDAO userDAO;
     public boolean isExist(String username) {
         User user = getByName(username);
         return  null!=user;
     }
     //通过get方法获取对象
    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }
    public User get(int id) {
        User u = userDAO.findById(id).orElse(null);
        return u;
    }
}