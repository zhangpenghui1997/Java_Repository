package cn.zph.test;

import cn.zph.dao.BookDao;
import cn.zph.dao.impl.BookDaoImpl;
import cn.zph.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
         Book book=new Book(null,"C语言程序设计","李雄",new BigDecimal(36.3),800,1000,null);
         bookDao.addBook(book);
    }

    @Test
    public void deleteBook() {
        if(bookDao.deleteBook(21)==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void updateBook() {
        Book book=new Book(3,"C语言程序设计","李雄",new BigDecimal(36.3),800,1000,null);
        if(bookDao.updateBook(book)==1){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }

    @Test
    public void queryById() {
        Book book = bookDao.queryById(1);
        System.out.println(book.toString());
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }

    }

    @Test
    public void queryForPageTotalCount() {
        int count=bookDao.queryForPageTotalCount();
        System.out.println(count);
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(8, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount1() {
        Integer count=bookDao.queryForPageTotalCountByPrice(100,200);
        System.out.println(count);
    }

    @Test
    public void queryForPageItems1() {
        List<Book> books = bookDao.queryForPageItemsByPrice(0, 4,0,200);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}