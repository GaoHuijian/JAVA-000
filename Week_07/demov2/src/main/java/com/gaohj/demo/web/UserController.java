package com.gaohj.demo.web;

import com.gaohj.demo.entity.User;
import com.gaohj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("findList")
    public List<User> findList(User user){
        return userService.findList(user);
    }

    @PostMapping("createUser")
    public Object save(@RequestBody  User user){
        userService.save(user);
        return "successs";
    }

}
