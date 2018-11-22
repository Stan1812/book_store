package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    List<Category> findAll();//查询所有书籍类别

    Category findCategoryByName(String name);//按名字查询类别

    Category findCategoryById(Long id);//按id查询类别

}
