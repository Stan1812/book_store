package com.expr.bookstore.dao;

import com.expr.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();
    List<Book> findBooksByCategoryId(Long categoryId);
    Book findBookById(Long aLong);
    Book findBookByName(String name);
}
