package cn.zph.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1.Filter构造器方法adminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter初始化方法init");

        System.out.println("filter-name:"+filterConfig.getFilterName());
        System.out.println("init-param username:"+filterConfig.getInitParameter("username"));
        System.out.println("init-param password:"+filterConfig.getInitParameter("password"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter doFilter方法");
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;

        HttpSession session=httpServletRequest.getSession();
        Object user=session.getAttribute("user");
        if(user==null){
            //拦截用户的访问，重定向
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest,servletResponse);
            return;
        }else{
            //让用户访问目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter destroy方法");
    }
}
