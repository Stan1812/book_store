package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.Category;
import com.expr.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/add")
    public @ResponseBody Category addNewCategory(@RequestParam String name, @RequestParam String description) {
        return categoryService.addNewCategory(name, description);
    }

    @PostMapping(path = "getAllCategories")
    public @ResponseBody
    List<Category> getAllCategories() {
        return categoryService.queryAllCategory();
    }

    @PostMapping(path = "getCategoryById")
    public @ResponseBody Category getCategoryById(@RequestParam Long id) {
        return categoryService.queryCategoryById(id);
    }

    @PostMapping(path = "getCategoryByName")
    public @ResponseBody Category getCategoryByName(@RequestParam String name) {
        return categoryService.queryCategoryByName(name);
    }
}
