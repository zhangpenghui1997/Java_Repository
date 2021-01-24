package com.zph.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zph.pojo.User;
import com.zph.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@Controller
@RestController //类中所有的方法返回值为字符串，不经过视图解析器
public class UserController {
    //@ResponseBody    //返回字符串，不经过视图解析器
    @RequestMapping(value = "/c5/t1")
    //解决乱码问题 @RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
    public String test1() throws JsonProcessingException {
        User user = new User(1, "张三", 15);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(user);
    }

    //@ResponseBody
    @RequestMapping("/c5/t2")
    public String test2() throws JsonProcessingException {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "张三", 15));
        userList.add(new User(2, "张三", 15));
        userList.add(new User(3, "张三", 15));
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(userList);
    }

    @RequestMapping("/c5/t3")
    public String test3() throws JsonProcessingException {
        Date date = new Date();
        String str = JsonUtils.getJson(date);
        return str;
    }

    @RequestMapping("/c5/t4")
    public String test4(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "张三", 15));
        userList.add(new User(2, "张三", 15));
        userList.add(new User(3, "张三", 15));
        String s = JSON.toJSONString(userList);
        return s;
    }
}
