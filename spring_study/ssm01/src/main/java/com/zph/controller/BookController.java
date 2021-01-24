package com.zph.controller;

import com.zph.pojo.Books;
import com.zph.service.BookService;
import com.zph.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier(value = "BookServiceImpl")
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/allBooks")
    public String getAllBooks(Model model) {

        List<Books> list = bookService.queryAllBooks();
        model.addAttribute("list", list);
        return "allBooks";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBook(Books book){
      /*  Books book = new Books();
        book.setBookName(bookName);
        book.setBookCounts(bookCounts);
        book.setDetail(detail);*/
        bookService.addBook(book);
        return "redirect:/book/allBooks";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(@RequestParam("id") int bookID, Model model){
        Books book = bookService.queryBook(bookID);
        model.addAttribute("book",book);
        return "updateBook";
    }
    @PostMapping("/updateBook")
    public String updateBook(Books book){
       /* Books book = new Books();
        book.setBookID(bookID);
        book.setBookName(bookName);
        book.setBookCounts(bookCounts);
        book.setDetail(detail);*/
        bookService.updateBook(book);
        return "redirect:/book/allBooks";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBooks";
    }
}
