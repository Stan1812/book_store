package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.OrderItem;
import com.expr.bookstore.entity.Orders;
import com.expr.bookstore.services.OrderItemService;
import com.expr.bookstore.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping(path = "/add")
    public @ResponseBody
    Orders addNewOrders(@RequestParam Double price,
                        @RequestParam Boolean state, @RequestParam Long userId) {
        return ordersService.addOrders(price, state, userId);
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
