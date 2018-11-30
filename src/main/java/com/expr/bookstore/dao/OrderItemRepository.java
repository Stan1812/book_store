package com.expr.bookstore.dao;

import com.expr.bookstore.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrderId(Long orderId);//通过orderId查询用户的所有订单项

    //OrderItem findOrderItemByBookIdAndOrderId(Long bookId, Long orderId);//通过bookId和orderId查询用户的某一个订单项

    OrderItem findOrderItemById(Long orderItemId);//通过orderItemId查询用户的某一订单项

    @Transactional
    @Override
    void deleteById(Long aLong);//通过id删除订单项

}
