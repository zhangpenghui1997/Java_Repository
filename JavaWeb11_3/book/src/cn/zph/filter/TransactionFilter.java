package cn.zph.filter;

import cn.zph.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
           try{
               filterChain.doFilter(servletRequest,servletResponse);
               //提交事务
               JdbcUtils.commitAndClose();
           }catch (Exception e){
               //回滚事务
               JdbcUtils.rollbackAndClose();
               e.printStackTrace();
               throw new RuntimeException();
               //把异常抛给tomcat服务器统一展示，友好的异常页面
           }
    }

    @Override
    public void destroy() {

    }
}
