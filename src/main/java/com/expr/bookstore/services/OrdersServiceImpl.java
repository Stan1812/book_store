package com.expr.bookstore.services;

import com.expr.bookstore.entity.Orders;
import com.expr.bookstore.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepo;

    /**
     * 添加购物车到数据库
     * @param orderTime 时间
     * @param price 总价格
     * @param state 状态
     * @param userId 用户id
     * @return 1
     */
    @Override
    public Orders addOrders(Timestamp orderTime, Double price, Boolean state, Long userId) {
        Orders orders = new Orders(orderTime, price, state, userId);
        return ordersRepo.save(orders);
    }

    /**
     * 通过用户id查找购物车
     * @param userId 用户id
     * @return 购物车
     */
    @Override
    public Optional<Orders> queryOrdersByUserId(Long userId) {
        return ordersRepo.findByUserId(userId);
    }
}
