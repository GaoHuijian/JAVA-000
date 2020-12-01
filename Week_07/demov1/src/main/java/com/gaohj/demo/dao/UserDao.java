package com.gaohj.demo.dao;

import com.gaohj.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao {

    public List<User> findList(User user);

    public int save(User user);
}
