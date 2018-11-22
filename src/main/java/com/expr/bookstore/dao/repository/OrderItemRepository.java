package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrderId(Long orderId);//通过orderId查询购物车单项

}
