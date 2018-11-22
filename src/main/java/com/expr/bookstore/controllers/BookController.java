package com.expr.bookstore.controllers;

import com.expr.bookstore.dao.entity.Book;
import com.expr.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/getAllBooks")
    public @ResponseBody
    List<Book> getAllBooks() {
        return bookService.queryAllBooks();
    }

    @PostMapping(path = "/add")
    public @ResponseBody int addNewBook(@RequestParam String name, @RequestParam String author,
                                        @RequestParam Double price, @RequestParam String image,
                                        @RequestParam String description, @RequestParam Long categoryId) {
        return bookService.addNewBook(name, author, price, image, description, categoryId);
    }

    @PostMapping(path = "/getAllBooksByCategory")
    public @ResponseBody List<Book> getAllBooksByCategory(@RequestParam Long categoryId) {
        return bookService.queryBooksByCategoryId(categoryId);
    }

    @PostMapping(path = "/getBookById")
    public @ResponseBody Book getBookById(@RequestParam Long id) {
        return bookService.queryBooksById(id);
    }

    @PostMapping(path = "/getBookByName")
    public @ResponseBody Book getBookByName(@RequestParam String name) {
        return bookService.queryBookByName(name);
    }
}
