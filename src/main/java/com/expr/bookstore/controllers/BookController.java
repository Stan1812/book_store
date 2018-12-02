package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.Book;
import com.expr.bookstore.entity.Category;
import com.expr.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/all")
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

    @PostMapping(path = "/booksByCategory")
    public @ResponseBody
    List<Book> getAllBooksByCategory(@RequestParam Long categoryId) {
        return bookService.queryBooksByCategoryId(categoryId);
    }

    @GetMapping(path = "/bookById")
    public @ResponseBody
    Book getBookById(@RequestParam Long id) {
        return bookService.queryBooksById(id);
    }

    @GetMapping(path = "/choice")
    public @ResponseBody
    List<Book> getChoice() {
     return  bookService.queryChoices();
    }

    @GetMapping(path = "/bookByName")
    public @ResponseBody
    Book getBookByName(@RequestParam String name) {
        return bookService.queryBookByName(name);
    }

    /**
     * 查询所有书籍时分页
     * @param page 第几页，从0开始
     * @param size 多大
     * @return books
     */
    @GetMapping(path = "/pageAll")
    public @ResponseBody
    List<Book> getBookPageByPageIdAndSize(@RequestParam Integer page, @RequestParam Integer size) {
        return bookService.findBookPage(page, size);
    }

    /**
     * 按类别查询时分页
     * @param categoryId 类别id
     * @param page 第几页，从0开始
     * @param size 页面大小
     * @return books
     */
    @GetMapping(path = "/pageByCategoryId")
    public @ResponseBody
    List<Book> getBookPageByCategory(@RequestParam Long categoryId, @RequestParam Integer page, @RequestParam Integer size) {
        return bookService.findBookPageByCategoryId(categoryId, page, size);
    }
}
