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
import java.util.List;



public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        Integer pageNo=WebUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize=WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);//前端不传pageSize的值时默认为bean设置的默认值
        //2.调用bookService.page(pageNo,pageSize); 返回页面对象
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //3.将页面对象保存到request域中
        request.setAttribute("page",page);
        //4.页面重定向
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(request.getParameter("pageNo"),0)+1;
        //request.setCharacterEncoding("UTF-8");//当请求方式是post时有效，get时无效
        //tomcat服务器默认编码不是UTF-8，需要修改server.xml文件，添加URIEncoding="UTF-8"
        //System.out.println(request.getParameter("name"));
        //1.获取book bean的属性值,注入到book对象中
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        //要使用重定向，而非请求转发（一次请求，刷新后会再次插入数据）
        //System.out.println(request.getContextPath());// /book,浏览器将"/"识别为   http://ip:port/
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);


    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取待删除图书的id
        Integer id=WebUtils.parseInt(request.getParameter("id"),1);
        //2.调用 bookService.deleteBook(id)方法删除图书记录
        bookService.deleteBook(id);
        //3.重定向
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 1.获取请求的参数封装成为Book对象 */
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());

        //2.调用BookService.updateBook(book)
        bookService.updateBook(book);

        //3.重定向到 request.getContextPath()+"/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过BookService 查询全部图书
        List<Book> bookList = bookService.queryBooks();
        //2.将图书的List添加到request域中
        request.setAttribute("bookList", bookList);
        //3.跳转到/pages/manager/book_manager.jsp
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

    }
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取待修改图书的编号
        Integer id=WebUtils.parseInt(request.getParameter("id"),0);
        //2.查询图书的信息
        Book book = bookService.queryBookById(id);
        //3.设置request域对象

        request.setAttribute("book",book);

        //4.请求转发/pages/manager/book_edit.jsp
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);

    }
}
