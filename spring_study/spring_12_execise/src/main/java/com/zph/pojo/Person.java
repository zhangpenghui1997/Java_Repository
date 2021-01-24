package com.zph.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Resource(name = "cat1")
    private Cat cat;
    @Resource(name = "dog1")
    private Dog dog;
}
