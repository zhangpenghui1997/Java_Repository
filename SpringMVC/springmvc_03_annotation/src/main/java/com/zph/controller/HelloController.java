package com.zph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("msg","hello SpringMVC");
        //  实际的访问地址: http://ip:port/工程路径/HelloController/hello
        return "hello";
    }
}
