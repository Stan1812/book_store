package com.expr.bookstore.dao;


import com.expr.bookstore.entity.Orders;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    List<Orders> findOrdersByUserId(Long userId);//通过userId查询购用户订单

    @Transactional
    void deleteById(Long id);//通过id删除

    @Transactional
    @Modifying
    @Query("update Orders set state = ?1 where id = ?2")
    int updateStateById(Boolean state, Long id);

}
