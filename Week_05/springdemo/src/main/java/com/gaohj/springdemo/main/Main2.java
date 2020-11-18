package com.gaohj.springdemo.main;

import com.gaohj.springdemo.beans.SchoolService;
import com.gaohj.springdemo.beans.User;
import com.gaohj.springdemo.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * java配置
 */
public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(JavaConfig.class);
        applicationContext.refresh();
        SchoolService schoolService = applicationContext.getBean(SchoolService.class);
        schoolService.query();
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
