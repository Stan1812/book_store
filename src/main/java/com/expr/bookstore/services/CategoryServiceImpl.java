package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.Category;
import com.expr.bookstore.dao.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    /**
     * 添加新的书籍类别到数据库
     * @param name 书籍类别名
     * @param description 类别描述信息
     * @return 1
     */
    @Override
    public int addNewCategory(String name, String description) {
        Category category = new Category(name, description);
        categoryRepo.save(category);
        return 1;
    }

    /**
     * 查询所有类别
     * @return categories 所有类别
     */
    @Override
    public List<Category> queryAllCategory() {
        return categoryRepo.findAll();
    }

    /**
     * 通过id查询类别
     * @param id 类别id
     * @return category
     */
    @Override
    public Category queryCategoryById(Long id) {
        return categoryRepo.findCategoryById(id);
    }

    /**
     * 通过名字查询类别
     * @param name 类别名
     * @return category
     */
    @Override
    public Category queryCategoryByName(String name) {
        return categoryRepo.findCategoryByName(name);
    }
}
