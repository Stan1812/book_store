package com.expr.bookstore.services;

import com.expr.bookstore.entity.Category;

import java.util.List;

public interface CategoryService {

    Category addNewCategory(String name, String description);

    List<Category> queryAllCategory();

    Category queryCategoryById(Long id);

    Category queryCategoryByName(String name);

}
