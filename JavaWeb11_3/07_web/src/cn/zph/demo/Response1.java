package cn.zph.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("曾到此一游---response1方法");
        //response.setStatus(302);
        //response.setHeader("Location","http://localhost:8080/07_web/response2");
        response.sendRedirect("http://localhost:8080/07_web/response2");
    }
}
