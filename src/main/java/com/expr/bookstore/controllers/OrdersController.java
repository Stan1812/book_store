package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.OrderItem;
import com.expr.bookstore.entity.Orders;
import com.expr.bookstore.entity.ShoppingCart;
import com.expr.bookstore.services.OrderItemService;
import com.expr.bookstore.services.OrdersService;
import com.expr.bookstore.services.ShoppingCartServce;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

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

    @Autowired
    private ShoppingCartServce  shoppingCartServce;
    @PostMapping(path = "/add")
    public @ResponseBody
    Map addNewOrders(@RequestBody Map order, @RequestAttribute Claims claims) {
        ObjectMapper mapper = new ObjectMapper();
        List<OrderItem> orderItems = mapper.convertValue(order.get("book"), new TypeReference<List<OrderItem>>() {
        });
        Double price = Double.valueOf(order.get("price").toString());
        Long userId = Long.parseLong(claims.getId());
        Timestamp date = new Timestamp(new Date().getTime());
        Orders savedOrder = ordersService.addOrders(date, price, userId);
        Long orderID = savedOrder.getId();
        for (OrderItem orderItem : orderItems) {
            orderItemService.addOrderItem(orderItem.getQuantity(), orderItem.getPrice(), orderID, orderItem.getBookId(),orderItem.getBookName());
        }
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("message", "add success");
        return res;
    }

    @GetMapping(path = "/deleteById")
    @ResponseBody
    public void deleteById(@RequestParam Long id) {
        ordersService.deleteOrderById(id);
    }

    /**
     * 查询某用户的所有订单以及订单中的商品项(OrderItem)
     *
     * @return 订单及对应订单项
     */
    @GetMapping(path = "/queryAllByUserId")
    @ResponseBody
    public List<Map> queryAllByUserId(@RequestAttribute Claims claims) {
        List<Map> res = new ArrayList<Map>();
        Long userId = Long.parseLong(claims.getId());
        List<Orders> orders = ordersService.queryOrdersByUserId(userId);
        for (Orders order1 : orders) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<OrderItem> orderItemList = orderItemService.queryOrderItemsByOrderId(order1.getId());
            map.put("book", orderItemList);
            map.put("orderDetail", order1);
            res.add(map);
        }
        return res;
    }
}
