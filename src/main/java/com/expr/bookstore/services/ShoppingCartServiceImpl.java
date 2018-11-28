package com.expr.bookstore.services;

import com.expr.bookstore.dao.BookRepository;
import com.expr.bookstore.dao.ShoppingCartRepository;
import com.expr.bookstore.entity.Book;
import com.expr.bookstore.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartServce {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private ShoppingCartRepository scRepo;


    /**
     * 通过userId和bookId添加一项到数据库，即在点击加入购物车时调用此服务
     * 如果该项购物车已存在，就更新，否则，就数据库插入
     * @param userId 用户id
     * @param bookId 书籍id
     * @return sc ShoppingCart的实体
     */
    @Override
    public ShoppingCart addNewShoppingCart(Long userId, Long bookId) {
        Book book = bookRepo.findBookById(bookId);
        ShoppingCart sc = null;
        if ((sc = scRepo.findShoppingCartByUserIdAndBookId(userId, bookId)) != null) {
            sc.setQuantity(sc.getQuantity() + 1);
            updateShoppingCart(sc.getQuantity(), bookId);
        }
        else {
            sc = new ShoppingCart(1, userId, bookId, book.getPrice());
            scRepo.save(sc);
        }
        return sc;
    }

    /**
     * 通过购物车项id更新购物车项的数量
     * @return 一个整数
     */
    @Override
    public int updateShoppingCart(Integer number, Long id) {
        if (number >= 1) {
            return scRepo.updateShoppingCart(number, id);
        }
        return -1;//禁止更新
    }

    /**
     * 通过id删除购物车项
     * @param id 购物车项id
     */
    @Override
    public void deleteShoppingCart(Long id) {
        scRepo.deleteShoppingCartById(id);
    }

    /**
     * 通过用户id查询该用户的所有购物车项
     * @param userId 用户id
     * @return 购物车列表
     */
    @Override
    public List<ShoppingCart> queryAllShoppingCartsByUserId(Long userId) {
        return scRepo.findAllByUserId(userId);
    }
}
