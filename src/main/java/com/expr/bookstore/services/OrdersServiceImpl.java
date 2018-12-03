package com.expr.bookstore.services;

import com.expr.bookstore.entity.Book;
import com.expr.bookstore.entity.Orders;
import com.expr.bookstore.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepo;


    @Override
    public Orders addOrders(Timestamp date, Double price,  Long userId) {
        Orders orders = new Orders(date, price, false, userId);
        return ordersRepo.save(orders);
    }

    /**
     * 通过用户id查找购物车
     * @param userId 用户id
     * @return 购物车
     */
    @Override
    public List<Orders> queryOrdersByUserId(Long userId) {
        return ordersRepo.findOrdersByUserId(userId);
    }

    /**
     * 通过id删除order
     * @param id order的id
     */
    @Override
    public void deleteOrderById(Long id) {
        ordersRepo.deleteById(id);
    }
}
