package com.zph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerTest4 {
    @GetMapping("/c4/t1/{a}/{b}")
    public String test1(@PathVariable String a, @PathVariable String b, Model model){
        model.addAttribute("msg","test1:"+a+b);
        return "/WEB-INF/jsp/test1.jsp";
    }

    @GetMapping("/c4/t2/{a}/{b}")
    public String test2(@PathVariable String a,@PathVariable String b, Model model){
        model.addAttribute("msg","test2:"+a+b);
        return "forward:/WEB-INF/jsp/test1.jsp";
    }

    @GetMapping("/c4/t3")
    public  String test3(){
       //重定向
        return "redirect:/a.jsp";
    }
}
