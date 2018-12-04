package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.OrderItem;
import com.expr.bookstore.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping(path = "/add")
    public @ResponseBody
    OrderItem addOrderItem(@RequestParam Integer quantity, @RequestParam Double price,
                           @RequestParam Long ordersId, @RequestParam Long bookId, @RequestParam String bookName) {
        return orderItemService.addOrderItem(quantity, price, ordersId, bookId, bookName);
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

    @PostMapping(path = "/queryById")
    @ResponseBody
    public OrderItem queryById(@RequestParam Long id) {
        return orderItemService.queryOrderItemById(id);
    }

    @PostMapping(path = "/queryAllByOrderId")
    @ResponseBody
    public List<OrderItem> queryAllBYOrderId(@RequestParam Long orderId) {
        return orderItemService.queryOrderItemsByOrderId(orderId);
    }

    @PostMapping(path = "/delete")
    public @ResponseBody
    void deleteOrderItem(@RequestParam Long id) {
        orderItemService.deleteOrderItemById(id);
    }
}
