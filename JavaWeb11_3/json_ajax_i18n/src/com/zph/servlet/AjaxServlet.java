package com.zph.servlet;

import com.google.gson.Gson;
import com.zph.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {
    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("Ajax请求过来了");
        Person person=new Person(1,"天朗气清，惠风和畅");
        Gson gson=new Gson();
        String jsonPersonString=gson.toJson(person);
        response.getWriter().write(jsonPersonString);

    }

    protected void jQueryGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("get请求过来了");
        Person person=new Person(1,"天朗气清，惠风和畅");
        Gson gson=new Gson();
        String jsonPersonString=gson.toJson(person);
        response.getWriter().write(jsonPersonString);
    }
    protected void jQueryPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("post请求过来了");
        Person person=new Person(1,"天朗气清，惠风和畅");
        Gson gson=new Gson();
        String jsonPersonString=gson.toJson(person);
        response.getWriter().write(jsonPersonString);
    }

    protected void getJson(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("getJson请求过来了");
        System.out.println("用户名："+request.getParameter("username"));
        System.out.println("密码："+request.getParameter("password"));
        Person person=new Person(1,"天朗气清，惠风和畅");
        Gson gson=new Gson();
        String jsonPersonString=gson.toJson(person);
        response.getWriter().write(jsonPersonString);
    }
}
