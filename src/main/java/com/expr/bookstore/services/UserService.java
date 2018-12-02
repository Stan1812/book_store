package com.expr.bookstore.services;

import com.expr.bookstore.entity.User;

public interface UserService {

    User addUser(String username, String password, String phone, String email, String address);//添加用户

    User login(String username, String password);
//    boolean isExistedByUsername(String username);//判断用户是否存在
//
//    boolean isExistedByPhone(String phone);//判断用户是否存在

    User queryUserByUsername(String username);

    User queryUserByPhone(String phone);

}