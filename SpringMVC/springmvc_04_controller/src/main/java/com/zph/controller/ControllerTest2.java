package com.zph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest2 {
    @RequestMapping("test2")
    public String testController(Model model){
        model.addAttribute("msg","Hello test2 controller");
        return "test1";         //            /WEB-INF/jsp/test1.jsp
    }
}
