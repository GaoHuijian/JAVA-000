package com.gaohj.springdemo.web;

import com.gaohj.springdemo.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    MsgService msgService;

    @RequestMapping("sentmsg")
    public String hello(){
        msgService.sendMsg("hello");
        return "true";
    }
}
