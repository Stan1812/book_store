package com.expr.bookstore.services;
import com.expr.bookstore.dao.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    void  addCustomer ();
}