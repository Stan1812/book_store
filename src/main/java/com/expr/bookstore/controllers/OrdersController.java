package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.Orders;
import com.expr.bookstore.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 购物车控制层
 */

@Controller
@RequestMapping(path = "/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping(path = "add")
    public @ResponseBody
    Orders addNewOrders(@RequestParam Timestamp datetime, @RequestParam Double price,
                        @RequestParam Boolean state, @RequestParam Long userId) {
        return ordersService.addOrders(datetime, price, state, userId);
    }
//
//    @GetMapping
//    public @ResponseBody
//    Orders queryOrdersByUserId(@RequestParam Long userId) {
//        return ordersService.queryOrdersByUserId(userId).get();
//    }
}
