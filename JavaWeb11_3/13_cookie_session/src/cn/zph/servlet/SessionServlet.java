package cn.zph.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isNew = session.isNew();
        String id = session.getId();
        response.getWriter().write("得到的session的id是：" + id + "<br/>");
        response.getWriter().write("这个session是否是新创建的：" + isNew + "<br/>");
    }

    /**
     * 保存session域中的数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("key1", "value1");
        response.getWriter().write("设置key1属性成功");
    }

    /**
     * 获取session域中的数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object attribute = request.getSession().getAttribute("key1");
        response.getWriter().write("从key1中获取的数据是：" + attribute);
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("session的默认超时时长为：" + maxInactiveInterval + "s");
    }

    protected void life3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
        response.getWriter().write("当前session已经设置超时时间为3秒");
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.getWriter().write("session已经设置为超时");
    }
}