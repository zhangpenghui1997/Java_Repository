package com.zph.config;

import com.zph.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.zph.pojo")
public class Config {

    @Bean
    public User getUser(){
        return new User();
    }
}
