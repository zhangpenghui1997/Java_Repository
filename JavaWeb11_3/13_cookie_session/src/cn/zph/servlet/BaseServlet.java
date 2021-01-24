package cn.zph.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        try {
            //反射代码编写，获取相应业务方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);//调用业务方法

        } catch (Exception e) {
            e.printStackTrace();
        }
         /*   if("login".equals(action)){
                //调用登录的业务逻辑函数
                login(request,response);

            }else if("regist".equals(action)){
                //调用注册的业务逻辑函数
               regist(request,response);

            }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        try {
            //反射代码编写，获取相应业务方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);//调用业务方法

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
