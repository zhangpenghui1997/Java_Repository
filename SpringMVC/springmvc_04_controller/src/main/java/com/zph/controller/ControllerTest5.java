package com.zph.controller;

import com.zph.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerTest5 {
    @GetMapping("/c5/t1")
    //请求参数添加注解 @RequestParam
    public String test1(@RequestParam("username") String name, Model model) {
        //System.out.println(name);
        model.addAttribute("msg", name);
        return "test1";
    }

    @GetMapping("/c5/t2")
    public String test2(User user, Model model) {
        model.addAttribute("msg", user.toString());
        return "test1";
    }

    @GetMapping("/c5/t3")
    public ModelAndView test3(@RequestParam("username") String username, ModelAndView modelAndView){
        modelAndView.addObject("msg",username);
        modelAndView.setViewName("test1");
        return modelAndView;
    }

}
