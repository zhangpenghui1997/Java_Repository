package cn.zph.service;

import cn.zph.pojo.Book;
import cn.zph.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(Integer pageNo, Integer pageSize);

    Page<Book> pageByPrice(Integer pageNo, Integer pageSize,Integer min,Integer max);
}
