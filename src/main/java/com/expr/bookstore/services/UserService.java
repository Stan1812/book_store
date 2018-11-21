package com.expr.bookstore.services;

import com.expr.bookstore.dao.User;

public interface UserService {
    public Iterable<User> getAllUsers();

    public int addUser(String name, String email);
}