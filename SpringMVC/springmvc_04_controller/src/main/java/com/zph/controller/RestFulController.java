package com.zph.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    @GetMapping("/restful/{a}/{b}")
    public String testGet(@PathVariable int a, @PathVariable int b, Model model){
        int result= a+b;
        model.addAttribute("msg","结果为(get方式)："+result);
        return "test1";
    }

    @PostMapping("/restful/{a}/{b}")
    public String testPost(@PathVariable String a,@PathVariable String b, Model model){
        String result = a+b;
        model.addAttribute("msg", "结果为(post方式)："+result);
        return "test1";
    }
}
