package com.expr.bookstore.services;

import com.expr.bookstore.dao.User;
import com.expr.bookstore.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepo;

    @Override
     public Iterable<User> getAllUsers() {
        return UserRepo.findAll();
    }
    @Override
    public int addUser(String name, String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        UserRepo.save(n);
        return 1;
    }
}