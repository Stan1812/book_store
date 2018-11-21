package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.User;
import com.expr.bookstore.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepo;

    @Override
    public int addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserRepo.save(user);
        return 1;
    }
}