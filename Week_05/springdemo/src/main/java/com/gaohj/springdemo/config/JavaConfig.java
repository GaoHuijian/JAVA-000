package com.gaohj.springdemo.config;

import com.gaohj.springdemo.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.gaohj")
public class JavaConfig {

    @Bean
    public User user() {
        return new User("", 32);
    }

}
