package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllByCategoryId(Long category);

    @Override
    Optional<Book> findById(Long aLong);

}
