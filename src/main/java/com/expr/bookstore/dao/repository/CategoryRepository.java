package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    List<Category> findAll();//查询所有书籍类别

}
