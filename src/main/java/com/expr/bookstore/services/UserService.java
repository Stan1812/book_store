package com.expr.bookstore.services;

import com.expr.bookstore.entity.User;

import java.util.List;

public interface UserService {

    User addUser(String username, String password, String phone, String email, String address);//添加用户
    User login(String username, String password);
    User queryUserByUsername(String username);
    List<User> findAll();
    User queryUserById(Long id);
}