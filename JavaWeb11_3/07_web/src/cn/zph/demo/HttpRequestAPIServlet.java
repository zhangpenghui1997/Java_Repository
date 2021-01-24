package cn.zph.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class HttpRequestAPIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("当前的请求方式："+request.getMethod());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("爱好："+ Arrays.asList(hobbies));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*System.out.println("请求的资源路径："+request.getRequestURI());
        System.out.println("请求的URL："+request.getRequestURL());
        System.out.println("请求的客户端IP："+request.getRemoteHost());
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("请求头："+request.getHeader("User-Agent"));*/
        System.out.println("当前的请求方式："+request.getMethod());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);

        }
    }
}
