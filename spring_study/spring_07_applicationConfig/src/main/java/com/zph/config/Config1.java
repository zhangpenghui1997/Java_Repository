package com.zph.config;

import com.zph.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.zph.pojo")
//相当于原来的beans.xml文件的作用
public class Config1 {
    @Bean
    public User getUser(){
        return new User();
    }
}
