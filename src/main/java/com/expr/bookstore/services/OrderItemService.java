package com.expr.bookstore.services;

import com.expr.bookstore.entity.OrderItem;
import org.hibernate.criterion.Order;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderItemService {

    OrderItem addOrderItem(Integer quantity, Double price, Long orderId, Long bookId);//向数据库添加订单项

    List<OrderItem> queryOrderItemsByOrderId(Long orderId);//通过订单号查询订单项

    void deleteOrderItemById(Long id);//通过id删除数据库中的购物车项

    OrderItem queryOrderItemById(Long id);

}
