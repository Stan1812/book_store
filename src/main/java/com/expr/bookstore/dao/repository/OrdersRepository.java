package com.expr.bookstore.dao.repository;


import com.expr.bookstore.dao.entity.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    Optional<Orders> findByUserId(Long userId);//通过userId查询购物车

}
