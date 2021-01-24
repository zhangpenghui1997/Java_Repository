package cn.zph.web;

import cn.zph.pojo.Book;
import cn.zph.pojo.Page;
import cn.zph.service.BookService;
import cn.zph.service.impl.BookServiceImpl;
import cn.zph.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BookServlet {
    private BookService bookService=new BookServiceImpl();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("经过了前台的ClientBookServlet程序");
        //1.获取请求的参数
        Integer pageNo=WebUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize=WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);//前端不传pageSize的值时默认为bean设置的默认值
        //2.调用bookService.page(pageNo,pageSize); 返回页面对象
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3.将页面对象保存到request域中
        request.setAttribute("page",page);
        //4.页面重定向
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);

    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取请求参数
        Integer pageNo=WebUtils.parseInt(request.getParameter("pageNo"),0);
        Integer pageSize=WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);
        Integer min=WebUtils.parseInt(request.getParameter("min"),0);
        Integer max=WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);
        //获取区间内的所有图书的数量
        StringBuilder strB=new StringBuilder("client/bookServlet?action=pageByPrice");
        Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);
        if(min!=null){
            strB.append("&min=").append(request.getParameter("min"));
        }
        if(max!=null){
            strB.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(strB.toString());
        request.setAttribute("page",page);
        request.setAttribute("min",min);
        request.setAttribute("max",max);
        //4.页面重定向
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);

    }
}
