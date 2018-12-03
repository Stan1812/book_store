package com.expr.bookstore.services;

import com.expr.bookstore.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartServce {

    ShoppingCart addNewShoppingCart(Long userId, Long bookId);

    int updateShoppingCart(Integer quantity, Long id,Long userId);

    void deleteShoppingCart(Long id);

    List<ShoppingCart> queryAllShoppingCartsByUserId(Long userId);

}
