package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.Book;

import java.util.List;

public interface BookService {

    int addNewBook(String name, String author, Double price, String image, String description, Long categoryId);

    List<Book> queryAllBooks();

    List<Book> queryBooksByCategoryId(Long categoryId);

    Book queryBooksById(Long id);

    Book queryBookByName(String name);

}
