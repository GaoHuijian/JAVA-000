package com.gaohj.springdemo.main;

import com.gaohj.springdemo.beans.SchoolService;
import com.gaohj.springdemo.beans.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.gaohj")
public class SpringBootApplicationMain {
    public static void main(String[] args) {
       ApplicationContext applicationContext = SpringApplication.run(SpringBootApplicationMain.class, args);
        SchoolService schoolService = applicationContext.getBean(SchoolService.class);
        schoolService.query();
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }

}
