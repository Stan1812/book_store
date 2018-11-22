package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.Category;

import java.util.List;

public interface CategoryService {

    int addNewCategory(String name, String description);

    List<Category> queryAllCategory();

    Category queryCategoryById(Long id);

    Category queryCategoryByName(String name);

}
