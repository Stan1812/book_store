package com.expr.bookstore.services;

import com.expr.bookstore.entity.Orders;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

public interface OrdersService {

    Orders addOrders(Timestamp orderTime, Double price, Boolean state, Long userId);//添加购物车

    Optional<Orders> queryOrdersByUserId(Long userId);//通过用户id查找购物车


}
