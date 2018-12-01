package com.expr.bookstore.services;

import com.expr.bookstore.entity.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

public interface OrdersService {

    Orders addOrders(Double price, Boolean state, Long userId);//添加购物车

    List<Orders> queryOrdersByUserId(Long userId);//通过用户id查找购物车

    @Transactional
    void deleteOrderById(Long id);

}
