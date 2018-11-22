package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.Book;
import com.expr.bookstore.dao.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    int addOrderItemService(Long ordersId, Long bookId);//向数据库添加购物车项

    List<OrderItem> queryOrderItemsByOrderId(Long orderId);//通过购物车号查询购物车项

//    boolean isExisted(Long bookId, Long orderId);//判断是否存在

    int addQuantityAndPriceByStep(OrderItem orderItem, Book book);//书籍的数目+1，价格加一倍

    int decQuantityAndPriceByStep(OrderItem orderItem);//书籍的数目-1，

    int updateQuantityAndPrice(OrderItem orderItem, Integer number);//书籍数目任意，价格相应增加

    int deleteOrderItemById(Long id);//通过id删除数据库中的购物车项
}
