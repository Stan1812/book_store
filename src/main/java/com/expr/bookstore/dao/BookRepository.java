package com.expr.bookstore.dao;

import com.expr.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();//查询所有书籍

    List<Book> findBooksByCategoryId(Long categoryId);//通过类别id查询所有书籍

    Book findBookById(Long aLong);//通过id查询书籍

    Book findBookByName(String name);//通过名字查书籍

}
