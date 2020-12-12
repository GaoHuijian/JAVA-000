package com.gaohj.demo.service;

import com.gaohj.demo.dao.UserDao;
import com.gaohj.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findList(User user){
        return userDao.findList(user);
    }

    public void save(User user) {
        user.setCreateBy("1");
        user.setUpdateBy("1");
        user.setUpdateDate(new Date());
        if(user.getId() == null){
            user.setCreateDate(new Date());
            userDao.save(user);
        }else{
            userDao.update(user);
        }

    }
}
