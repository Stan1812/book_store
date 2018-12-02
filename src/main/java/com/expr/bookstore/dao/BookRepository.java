package com.expr.bookstore.dao;

import com.expr.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Override
    List<Book> findAll();
    List<Book> findBooksByCategoryId(Long categoryId);
    Book findBookById(Long aLong);
    Book findBookByName(String name);

}
