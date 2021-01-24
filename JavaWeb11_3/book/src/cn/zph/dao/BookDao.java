package cn.zph.dao;

import cn.zph.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryById(Integer id);

    public List<Book> queryBooks();

    int queryForPageTotalCount();

    int queryForPageTotalCountByPrice(int min,int max);

    List<Book> queryForPageItems(int begin,int pageSize);

    List<Book> queryForPageItemsByPrice(int begin,int pageSize,int min,int max);

}
