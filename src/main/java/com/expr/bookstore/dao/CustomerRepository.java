package com.expr.bookstore.dao;

//import com.expr.bookstore.dao.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
