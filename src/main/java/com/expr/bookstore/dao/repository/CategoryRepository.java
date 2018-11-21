package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    Iterable<Category> findAll();

}
