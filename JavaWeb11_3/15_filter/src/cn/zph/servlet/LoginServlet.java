package cn.zph.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html;charset=utf-8");
       String username=req.getParameter("username");
       String password=req.getParameter("password");
       if("abc".equals(username)&&"123456".equals(password)){
           req.getSession().setAttribute("user",username);
           resp.getWriter().write("登录成功");
       }else{
           req.getRequestDispatcher("/login.jsp").forward(req,resp);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
