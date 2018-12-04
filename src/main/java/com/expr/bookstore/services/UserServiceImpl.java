package com.expr.bookstore.services;

import com.expr.bookstore.entity.User;
import com.expr.bookstore.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    /**
     * 向数据库添加用户
     * @param username 用户名
     * @param password 密码
     * @return 1
     */
    @Override
    public User addUser(String username, String password, String phone, String email, String address) {
        User user = new User(username, password, phone, email, address);
        return userRepo.save(user);
    }

    @Override
    public User login(String userName,String password){
     return  new User();
    }

    @Override
    public User queryUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }
    @Override
    public List<User> findAll(){
        return userRepo.findAll();
    }
    /**
     * 在数据库中查询手机号为phone的用户
     * @param id
     * @return 用户
     */
    @Override
    public User queryUserById(Long id) {
        return userRepo.findUserById(id);
    }
}