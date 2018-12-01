package com.expr.bookstore.dao;


import com.expr.bookstore.entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    List<Orders> findOrdersByUserId(Long userId);//通过userId查询购用户订单

    @Transactional
    void deleteById(Long id);//通过id删除

}
