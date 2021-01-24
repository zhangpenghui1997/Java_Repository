package cn.zph.web;

import cn.zph.pojo.User;
import cn.zph.service.UserService;
import cn.zph.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.获取请求参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //2.调用userService成员方法判断登录是否成功
        User user=new User(null,username,password,null);
        if(userService.login(user)!=null){
            //登录成功,跳转到login_success.jsp
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);

        }else{
            //登录失败,跳转到login.jsp
            request.setAttribute("message","用户名或密码错误");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
