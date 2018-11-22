package com.expr.bookstore.controllers;

import com.expr.bookstore.dao.entity.Orders;
import com.expr.bookstore.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 购物车控制层
 */

@Controller
@RequestMapping(path = "/demo")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public @ResponseBody int addNewOrders(@RequestParam Date datetime, @RequestParam Double price,
                                          @RequestParam Boolean state, @RequestParam Long userId) {
        return ordersService.addOrders(datetime, price, state, userId);
    }

    @GetMapping
    public @ResponseBody
    Orders queryOrdersByUserId(@RequestParam Long userId) {
        return ordersService.queryOrdersByUserId(userId).get();
    }
}
