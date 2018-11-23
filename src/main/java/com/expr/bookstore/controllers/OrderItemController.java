package com.expr.bookstore.controllers;

import com.expr.bookstore.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping(path = "/addOrderItem")
    public @ResponseBody int addOrderItem(@RequestParam Long ordersId, @RequestParam Long bookId) {
        return orderItemService.addOrderItemService(ordersId, bookId);
    }

//    @PostMapping(path = "/addQuantityOne")
//    public @ResponseBody int addQuantityOne(@RequestParam Integer number,
//                                            @RequestParam Double price, @RequestParam Long id) {
//        return orderItemService.updateQuantityAndPrice(number, price, id);
//    }
//
//    @PostMapping(path = "/decQuantityOne")
//    public @ResponseBody int decQuantityOne(@RequestParam Integer number,
//                                            @RequestParam Double price, @RequestParam Long id) {
//        return orderItemService.updateQuantityAndPrice(number, price, id);
//    }

    @PostMapping(path = "/updateOrderItem")
    public @ResponseBody int updateOrderItem(@RequestParam Integer number,
                                            @RequestParam Double price, @RequestParam Long id) {
        return orderItemService.updateQuantityAndPrice(number, price, id);
    }

    @PostMapping(path = "delete")
    public @ResponseBody void deleteOrderItem(@RequestParam Long id) {
        orderItemService.deleteOrderItemById(id);
    }
}
