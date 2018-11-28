package com.expr.bookstore.dao;

import com.expr.bookstore.entity.ShoppingCart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

    List<ShoppingCart> findAllByUserId(Long userId);//通过用户id查询出该用户的所有购物车项

    ShoppingCart findShoppingCartById(Long id);

    ShoppingCart findShoppingCartByUserIdAndBookId(Long userId, Long bookId);

    @Transactional
    @Modifying
    @Query("update ShoppingCart set number=?1 where id=?2")
    int updateShoppingCart(Integer number, Long id);

    @Transactional
    void deleteShoppingCartById(Long id);

}
