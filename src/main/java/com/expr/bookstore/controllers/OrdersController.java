package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.Book;
import com.expr.bookstore.entity.OrderItem;
import com.expr.bookstore.entity.Orders;
import com.expr.bookstore.services.OrderItemService;
import com.expr.bookstore.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 订单控制层
 */
@Controller
@RequestMapping(path = "/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    /**
     * 添加订单到数据库
     * @param price 价格
     * @param orderItems 订单项列表
     * @param userId 用户id
     * @return 存入的订单
     */
    @PostMapping(path = "/add")
    public @ResponseBody
    Orders addNewOrders(@RequestParam Double price, @RequestParam List<OrderItem> orderItems, @RequestParam Long userId) {
        Timestamp date = new Timestamp(new Date().getTime());
        for (OrderItem orderItem : orderItems) {
            orderItemService.addOrderItem(orderItem.getQuantity(), orderItem.getPrice(), orderItem.getOrderId(), orderItem.getBookId());
        }
        return ordersService.addOrders(date, price, userId);
    }

    @PostMapping(path = "/deleteById")
    @ResponseBody
    public void deleteById(@RequestParam Long id) {
        ordersService.deleteOrderById(id);
    }

    /**
     * 查询某用户的所有订单以及订单中的商品项(OrderItem)
     * @param userId 用户id
     * @return 订单及对应订单项
     */
    @GetMapping(path = "/queryAllByUserId")
    @ResponseBody
    public LinkedHashMap<Orders, List<OrderItem>> queryAllByUserId(@RequestParam Long userId) {
        LinkedHashMap<Orders, List<OrderItem>> map = new LinkedHashMap<>();
        List<Orders> orders = ordersService.queryOrdersByUserId(userId);
        for (Orders orders1 : orders) {
            List<OrderItem> orderItemList = orderItemService.queryOrderItemsByOrderId(orders1.getId());
            map.put(orders1, orderItemList);
        }
        return map;
    }
}
