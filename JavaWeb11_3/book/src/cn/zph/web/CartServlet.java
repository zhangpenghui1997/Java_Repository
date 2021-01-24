package cn.zph.web;

import cn.zph.pojo.Book;
import cn.zph.pojo.Cart;
import cn.zph.pojo.CartItem;
import cn.zph.service.BookService;
import cn.zph.service.impl.BookServiceImpl;
import cn.zph.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 加入购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //调用bookService.queryBookById获取图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem = new CartItem();
        cartItem.setId(book.getId());
        cartItem.setPrice(book.getPrice());
        cartItem.setCount(1);
        cartItem.setTotalPrice(book.getPrice());
        cartItem.setName(book.getName());
        //添加商品项
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        //保存最后一次加入购物车的图书名称
        request.getSession().setAttribute("lastName",cartItem.getName());
        cart.addItem(cartItem);
       // System.out.println(cart);
        //请求头的Referer字段表明浏览器从哪个页面跳转过来
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Cart cart =(Cart) request.getSession().getAttribute("cart");
        cart.deleteItem(id);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart =(Cart) request.getSession().getAttribute("cart");
        cart.clear();
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart =(Cart) request.getSession().getAttribute("cart");
        int count=WebUtils.parseInt(request.getParameter("count"),1);
        if (count < 1) {
            count=1;
        }
        int id=WebUtils.parseInt(request.getParameter("id"),1);
        cart.updateCount(id,count);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> resultMap=new HashMap<>();
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //调用bookService.queryBookById获取图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem = new CartItem();
        cartItem.setId(book.getId());
        cartItem.setPrice(book.getPrice());
        cartItem.setCount(1);
        cartItem.setTotalPrice(book.getPrice());
        cartItem.setName(book.getName());
        //添加商品项
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);

        }
        //保存最后一次加入购物车的图书名称
        request.getSession().setAttribute("lastName",cartItem.getName());
        cart.addItem(cartItem);
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson=new Gson();
        response.getWriter().write(gson.toJson(resultMap));
    }
}
