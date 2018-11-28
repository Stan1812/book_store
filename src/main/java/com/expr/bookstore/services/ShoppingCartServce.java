package com.expr.bookstore.services;

import com.expr.bookstore.entity.ShoppingCart;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShoppingCartServce {

    ShoppingCart addNewShoppingCart(Long userId, Long bookId);

    @Transactional
    int updateShoppingCart(Integer number, Long id);

    @Transactional
    void deleteShoppingCart(Long id);

    List<ShoppingCart> queryAllShoppingCartsByUserId(Long userId);

}
