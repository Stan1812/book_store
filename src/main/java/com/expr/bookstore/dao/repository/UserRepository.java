package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByUsername(String username);//通过用户名查询用户

    Optional<User> findUserByPhone(String phone);//通过手机号码查询用户

}