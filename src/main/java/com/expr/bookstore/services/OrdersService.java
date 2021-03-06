package com.expr.bookstore.services;

import com.expr.bookstore.entity.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface OrdersService {

    Orders addOrders(Timestamp date, Double price, Long userId);//添加购物车

    List<Orders> queryOrdersByUserId(Long userId);//通过用户id查找购物车

    @Transactional
    void deleteOrderById(Long id);

    @Transactional
    int updateStateById(Boolean state, Long id);
}
