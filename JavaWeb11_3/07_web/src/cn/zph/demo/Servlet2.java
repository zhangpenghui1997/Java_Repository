package cn.zph.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //证明材料
        System.out.println("username:"+username);
        Object key = request.getAttribute("key");
        System.out.println("servlet1的章"+key.toString());

        //Servlet2自己的处理逻辑
        System.out.println("Servlet2自己的处理逻辑");


    }
}
