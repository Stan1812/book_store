package com.expr.bookstore.services;

import com.expr.bookstore.dao.BookRepository;
import com.expr.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 书籍服务类的具体实现
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    /**
     * 添加书籍到数据库
     *
     * @param name        书名
     * @param author      作者
     * @param press       出版社
     * @param score       评分
     * @param price       价格
     * @param image       图片路径
     * @param description 书籍简介
     * @param commentNum  评价数
     * @param categoryId  书籍类别
     * @return book
     */
    @Override
    public Book addNewBook(String name, String author, String press, Double price, Double score, String image, Integer commentNum, String description, Long categoryId) {
        Book book = new Book(name, author, press, price, score, image, commentNum, description, categoryId);
        return bookRepo.save(book);
    }

    /**
     * 查询精选书籍
     * @return books 豆瓣评分最高的前5
     */
    @Override
    public List<Book> queryChoices() {
        List allList = bookRepo.findAll();
        Collections.sort(allList, (Comparator<Book>) (book1, book2) -> {
            if (book1.getScore() < book2.getScore()) {
                return 1;
            }
            if (book1.getScore() == book2.getScore()) {
                return 0;
            }
            return -1;
        });
        return allList.subList(0, 5);
    }

    /**
     * 查询所有书籍
     *
     * @return books 所有书籍的列表
     */
    @Override
    public List<Book> queryAllBooks() {
        return bookRepo.findAll().subList(0,20);
    }

    /**
     * 通过书籍类别查询书籍
     *
     * @param categoryId 书籍类别
     * @return books 对应类别的所有书籍
     */
    @Override
    public List<Book> queryBooksByCategoryId(Long categoryId) {
        return bookRepo.findBooksByCategoryId(categoryId);
    }

    /**
     * 通过id查找书籍
     *
     * @param id 书籍id
     * @return book 查找到的书籍
     */
    @Override
    public Book queryBooksById(Long id) {
        return bookRepo.findBookById(id);
    }

    /**
     * 通过书名查询书籍
     *
     * @param name 书名
     * @return book 对应书名的书籍
     */
    @Override
    public Book queryBookByName(String name) {
        return bookRepo.findBookByName(name);
    }

    /**
     * 实现分页查询：面对查询所有书籍
     * @param page 页数
     * @param size 页的大小
     * @return  page
     */
    @Override
    public List<Book> findBookPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<Book> bookPage = bookRepo.findAll(pageable);
        List<Book> books = new ArrayList<>();
        for (Book aBookPage : bookPage) {
            books.add(aBookPage);
        }
        return books;
    }

    /**
     * 实现分页查询：面对通过类别查询书籍
     * @param categoryId 类别id
     * @return page
     */
    @Override
    public List<Book> findBookPageByCategoryId(Long categoryId, Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        List<Book> books = new ArrayList<>();
        Page<Book> bookPage = bookRepo.findAll((Specification<Book>) (root, query, criteriaBuilder) -> {
            Predicate p = criteriaBuilder.equal(root.get("categoryId").as(Long.class), categoryId);
            query.where(criteriaBuilder.and(p));
            return query.getRestriction();
        }, pageable);
        for (Book book : bookPage) {
            books.add(book);
        }
        return books;
    }
}
