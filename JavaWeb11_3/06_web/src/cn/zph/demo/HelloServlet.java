package cn.zph.demo;

import com.sun.deploy.services.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化方法");
        System.out.println("Servlet程序别名为："+servletConfig.getServletName());
        System.out.println("Servlet程序参数为："+servletConfig.getInitParameter("url"));
        System.out.println("Servlet程序参数为："+servletConfig.getInitParameter("username"));
        System.out.println("Servlet程序上下文参数为："+servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        System.out.println("3.service方法-------HelloServlet被访问了！ ");
        if("POST".equals(method)){
           doPost();
        }else if("GET".equals(method)){
            doGet();
        }
    }
    public void doGet(){
        System.out.println("get方法");
        System.out.println("get方法");
        System.out.println("get方法");
    }

    public void doPost(){
        System.out.println("post方法");
        System.out.println("post方法");
        System.out.println("post方法");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.调用销毁方法");
    }
}
