package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.Orders;
import com.expr.bookstore.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物车控制层
 */
@Controller
@RequestMapping(path = "/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

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

    @PostMapping(path = "/queryAllByUserId")
    @ResponseBody
    public List<Orders> queryAllByUserId(@RequestParam Long userId) {
        return ordersService.queryOrdersByUserId(userId);
    }
}
