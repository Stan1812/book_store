package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.Book;
import com.expr.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/getAllBooks")
    public @ResponseBody
    List<Book> getAllBooks() {
        return bookService.queryAllBooks();
    }
    @PostMapping(path = "/add")
    public @ResponseBody
    Book addNewBook(@RequestParam String name,
                    @RequestParam String author,
                    @RequestParam Double price,
                    @RequestParam Double score,
                    @RequestParam String press,
                    @RequestParam String image,
                    @RequestParam String description,
                    @RequestParam Integer commentNum,
                    @RequestParam Long categoryId) {
        return bookService.addNewBook(name, author, press, price, score, image, commentNum, description, categoryId);
    }

    @PostMapping(path = "/getAllBooksByCategory")
    public @ResponseBody
    List<Book> getAllBooksByCategory(@RequestParam Long categoryId) {
        return bookService.queryBooksByCategoryId(categoryId);
    }
    @GetMapping(path = "/getBookById")
    public @ResponseBody
    Book getBookById(@RequestParam Long id) {
        return bookService.queryBooksById(id);
    }

    @PostMapping(path = "/getBookByName")
    public @ResponseBody
    Book getBookByName(@RequestParam String name) {
        return bookService.queryBookByName(name);
    }
}
