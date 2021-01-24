package com.zph.service;

import com.zph.pojo.Books;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("BookServiceImpl", BookService.class);
        List<Books> books = bookService.queryAllBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("BookServiceImpl", BookService.class);
        List<Books> list = bookService.searchBook("程");
        for (Books books : list) {
            System.out.println(books);
        }
    }
}
