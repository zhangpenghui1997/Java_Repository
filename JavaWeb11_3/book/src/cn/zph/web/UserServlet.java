package cn.zph.web;

import cn.zph.pojo.User;
import cn.zph.service.UserService;
import cn.zph.service.impl.UserServiceImpl;
import cn.zph.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * login
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    //处理登录业务逻辑的方法
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用userService成员方法判断登录是否成功
        User user = new User(null, username, password, null);
        User loginUser=userService.login(user);
        if (loginUser != null) {
            //保存用户登录的信息到Session域中

            request.getSession().setAttribute("user",loginUser);
            //登录成功,跳转到login_success.jsp
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);

        } else {
            //登录失败,跳转到login.jsp
            request.setAttribute("message", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    /**
     * regist
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);//获取完之后马上删除，避免使用第二次
        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user =  WebUtils.copyParamToBean(request.getParameterMap(), new User());

        //2.检查验证码是否正确
        if (token!=null&&token.equalsIgnoreCase(code)) {
            //正确
            //3.判断用户名是否可用，如果可用保存到数据库，跳转到regist_success.jsp;
            // 不可用跳回注册页面
            if (!userService.existsUsername(username)) {
                //用户名可用
                //User user = new User(null, username, password, email);
                //插入数据，注册成功
                userService.registUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);

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
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //让session会话变得无效
        request.getSession().invalidate();
        //System.out.println(request.getContextPath());  //  /book --->   http://localhost:8081/book
      response.sendRedirect(request.getContextPath());

    }
    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        Map<String,Object> map=new HashMap<String,Object>();
        boolean existsUsername = userService.existsUsername(username);
        map.put("message",existsUsername);
        Gson gson=new Gson();
        response.getWriter().write(gson.toJson(map));
    }

}
