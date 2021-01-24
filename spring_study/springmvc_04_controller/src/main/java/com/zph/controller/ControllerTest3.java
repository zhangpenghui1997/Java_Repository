package com.zph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest3  {

    @RequestMapping("/c3/t1")
    public String test1(Model model){
        model.addAttribute("msg","Hello test1 ControllerTest3");
        return "test1";
    }
}
