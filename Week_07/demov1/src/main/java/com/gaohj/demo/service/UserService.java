package com.gaohj.demo.service;

import com.gaohj.demo.dao.UserDao;
import com.gaohj.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findList(User user){
        return userDao.findList(user);
    }
}
