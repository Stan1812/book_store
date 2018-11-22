package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllByCategoryId(Long category);//通过类别查询所有书籍

    Optional<Book> findById(Long aLong);//通过id查询书籍

}
