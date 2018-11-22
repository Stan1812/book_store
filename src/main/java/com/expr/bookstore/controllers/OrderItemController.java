package com.expr.bookstore.controllers;

import com.expr.bookstore.services.OrderItemService;
import com.expr.bookstore.services.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping(path = "/addOrderItem")
    public @ResponseBody int addOrderItem(@RequestParam Long ordersId, @RequestParam Long bookId) {
        return orderItemService.addOrderItemService(ordersId, bookId);
    }

}
