package com.expr.bookstore.dao;

import com.expr.bookstore.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);//通过用户名查询用户

    User findUserByPhone(String phone);//通过手机号码查询用户

}