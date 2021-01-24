package com.zph.mapper;

import com.zph.pojo.Books;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books book);

    //删除一本书
    int deleteBook(@Param("bookID") int id);

    //修改一本书的信息
    int updateBook(Books book);

    //查询一本书的信息
    Books queryBook(@Param("bookID") int id);

    //查询所有的图书信息
    List<Books> queryAllBooks();
}
