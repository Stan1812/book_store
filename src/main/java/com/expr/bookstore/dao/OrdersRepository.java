package com.expr.bookstore.dao;


import com.expr.bookstore.entity.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    Optional<Orders> findByUserId(Long userId);//通过userId查询购物车

}
