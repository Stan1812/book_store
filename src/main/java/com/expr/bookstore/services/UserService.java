package com.expr.bookstore.services;

public interface UserService {

    int addUser(String username, String password, String phone, String cellphone, String email, String address);//添加用户

    boolean isExistedByUsername(String username);//判断用户是否存在

    boolean isExistedByPhone(String phone);//判断用户是否存在

}