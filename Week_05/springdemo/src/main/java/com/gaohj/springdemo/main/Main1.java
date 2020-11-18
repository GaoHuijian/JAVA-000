package com.gaohj.springdemo.main;

import com.gaohj.springdemo.beans.SchoolService;
import com.gaohj.springdemo.beans.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml
 * 注解
 */
public class Main1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beandefine.xml");
        User user1 = (User) applicationContext.getBean("user1");
        System.out.println(user1);
        User user2= (User) applicationContext.getBean("user2");
        System.out.println(user2);
        User user3= (User) applicationContext.getBean("user2");
        System.out.println(user3);
        SchoolService schoolService = applicationContext.getBean(SchoolService.class);
        schoolService.query();
    }
}
