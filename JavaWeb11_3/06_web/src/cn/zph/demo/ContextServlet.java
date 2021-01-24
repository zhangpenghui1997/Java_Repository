package cn.zph.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println("当前路径："+servletContext.getContextPath());
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("工程部署的路径是："+servletContext.getRealPath("/"));
        System.out.println("工程部署下的css路径是："+servletContext.getRealPath("/css"));

        servletContext.setAttribute("key1","value1");
        System.out.println("context对象中的key1的值:"+servletContext.getAttribute("key1"));

    }
}
