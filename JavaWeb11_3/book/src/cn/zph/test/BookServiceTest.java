package cn.zph.test;

import cn.zph.pojo.Book;
import cn.zph.pojo.Page;
import cn.zph.service.BookService;
import cn.zph.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
     private BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        Book book=new Book(null,"C语言程序设计","李雄",new BigDecimal(36.3),800,1000,null);
        bookService.addBook(book);
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(22);
    }

    @Test
    public void updateBook() {
        Book book=new Book(20,"C语言程序设计","李雄",new BigDecimal(36.3),800,1000,null);
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(10);
        System.out.println(book.toString());
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void page1() {
        Page<Book> page = bookService.pageByPrice(1, 4,10,50);
        System.out.println(page);
    }
}