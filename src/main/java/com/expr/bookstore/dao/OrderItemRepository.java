package com.expr.bookstore.dao;

import com.expr.bookstore.entity.OrderItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrderId(Long orderId);//通过orderId查询用户的所有购物车项

    OrderItem findOrderItemByBookIdAndOrderId(Long bookId, Long orderId);//通过bookId和orderId查询用户的某一个购物车项

    OrderItem findOrderItemById(Long orderItemId);//通过orderItemId查询用户的某一购物车项

    @Transactional
    @Modifying
    @Query("update OrderItem set quantity=?1,price=?2 where id=?3")
    int modifyById(Integer quantity, Double price, Long id);//修改购物车项中书的数量和总价价格

    @Transactional
    @Override
    void deleteById(Long aLong);//通过id删除购物车项
}
