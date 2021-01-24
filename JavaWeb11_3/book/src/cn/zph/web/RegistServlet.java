package cn.zph.web;

import cn.zph.pojo.User;
import cn.zph.service.UserService;
import cn.zph.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //2.检查验证码是否正确,先写死
        if ("bnbnp".equalsIgnoreCase(code)) {
            //正确
            //3.判断用户名是否可用，如果可用保存到数据库，跳转到regist_success.jsp;
            // 不可用跳回注册页面
            if (!userService.existsUsername(username)) {
                //用户名可用
                User user = new User(null, username, password, email);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
                //插入数据，注册成功
                userService.registUser(user);
            } else {
                //用户名不可用
                //System.out.println("用户名【"+username+"】已存在，请更换");
                request.setAttribute("message", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }

        } else {
            //验证码不正确
            //System.out.println("验证码错误：" + code);
            request.setAttribute("message", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了get方法");
    }
}
