package cn.zph.servlet;

import cn.zph.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie iWantCookie = null;
        for (Cookie cookie : cookies) {
           // response.getWriter().write("[" + cookie.getName() + "=" + cookie.getValue() + "]<br>");
            if("key2".equals(cookie.getName())){
                iWantCookie=cookie;
                break;
            }
        }
      if(iWantCookie!=null){
            response.getWriter().write("找到了需要的Cookie"+iWantCookie.getName());
      }


    }

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie cookie = new Cookie("key2", "value2");
        //2.通知客户端保存cookie
        response.addCookie(cookie);
        //1.创建cookie对象
        Cookie cookie1 = new Cookie("key3", "value3");
        //2.通知客户端保存cookie
        response.addCookie(cookie1);

        response.getWriter().write("cookie创建成功");

    }
    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  Cookie cookie=new Cookie("key1","newValue");
        response.addCookie(cookie);
        response.getWriter().write("key1的值已经修改");*/
        Cookie cookie = CookieUtils.findCookie("key2", request.getCookies());

       if(cookie!=null){
           cookie.setValue("newValue2");
           response.addCookie(cookie);
           response.getWriter().write("key2的值已经修改");
       }
    }
    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);

    }
    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key2", request.getCookies());
        if(cookie!=null){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("life3600","life3600");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        response.getWriter().write("已经设置了存活一小时的cookie");
    }

    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("path1","path1");
        cookie.setPath(request.getContextPath()+"/abc");
        System.out.println(cookie.getPath());
        response.addCookie(cookie);
    }
}
