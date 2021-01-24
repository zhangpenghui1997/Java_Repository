package com.zph.service;

import com.zph.pojo.Books;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books book);

    //删除一本书
    int deleteBook(int id);

    //修改一本书的信息
    int updateBook(Books book);

    //查询一本书的信息
    Books queryBook( int id);

    //查询所有的图书信息
    List<Books> queryAllBooks();
}
