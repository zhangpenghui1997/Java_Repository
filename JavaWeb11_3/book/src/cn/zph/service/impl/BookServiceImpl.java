package cn.zph.service.impl;

import cn.zph.dao.BookDao;
import cn.zph.dao.impl.BookDaoImpl;
import cn.zph.pojo.Book;
import cn.zph.pojo.Page;
import cn.zph.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {

        Page<Book> page = new Page<>();

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        Integer pageTotal = pageTotalCount % pageSize > 0 ? pageTotalCount / pageSize + 1 : pageTotalCount / pageSize;
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * page.getPageSize();
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {

        Page<Book> page=new Page<>();
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        Integer pageTotal = pageTotalCount % pageSize > 0 ? pageTotalCount / pageSize + 1 : pageTotalCount / pageSize;
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * page.getPageSize();
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);
        page.setItems(items);

        return page;
    }




}
