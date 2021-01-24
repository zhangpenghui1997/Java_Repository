package com.zph.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@Data
public class Person {
    @Autowired(required = false)
    private Dog dog;
    @Resource(name="cat1")
    private Cat cat;

}
