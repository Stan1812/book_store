package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.Orders;

import java.util.Date;
import java.util.Optional;

public interface OrdersService {

    int addOrders(Date orderTime, Double price, Boolean state, Long userId);//添加购物车

    Optional<Orders> queryOrdersByUserId(Long userId);//通过用户id查找购物车


}
