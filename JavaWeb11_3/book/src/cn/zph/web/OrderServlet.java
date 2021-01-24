package cn.zph.web;

import cn.zph.pojo.Cart;
import cn.zph.pojo.User;
import cn.zph.service.OrderService;
import cn.zph.service.impl.OrderServiceImpl;
import cn.zph.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //从session中获取cart和user对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("message","请先进行登录");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;//最好要加上去
        }
        //System.out.println("OrderServlet程序在"+Thread.currentThread().getName()+"线程中");
        Integer userId=user.getId();
        String orderId = null;
        orderId = orderService.createOrder(cart, userId);

        request.getSession().setAttribute("orderId",orderId);
        //request.setAttribute("orderId",orderId);
        //要使用重定向,防止表单重复提交
      //  request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);

        //清空购物车

        Cart currentCart=(Cart)request.getSession().getAttribute("cart");
        currentCart.clear();
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
