package com.expr.bookstore.services;

import com.expr.bookstore.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    Book addNewBook(String name, String author, String press, Double price, Double score, String image, Integer commentNum, String description, Long categoryId);

    List<Book> queryAllBooks();

    List<Book> queryBooksByCategoryId(Long categoryId);
    List<Book> queryChoices();
    Book queryBooksById(Long id);

    Book queryBookByName(String name);

    List<Book> findBookPage(Integer page, Integer size);

    List<Book> findBookPageByCategoryId(Long categoryId, Integer page, Integer size);

}
