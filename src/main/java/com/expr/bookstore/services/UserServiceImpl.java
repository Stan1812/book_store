package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.User;
import com.expr.bookstore.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepo;

    /**
     * 向数据库添加用户
     * @param username 用户名
     * @param password 密码
     * @return 1
     */
    @Override
    public int addUser(String username, String password, String phone, String cellphone, String email, String address) {
        User user = new User(username, password, phone, cellphone, email, address);
        UserRepo.save(user);
        return 1;
    }

    /**
     * 在数据库中查找用户名为username的用户是否存在
     * @param username 用户名
     * @return 存在与否
     */
    @Override
    public boolean isExistedByUsername(String username) {
        return UserRepo.findUserByUsername(username).isPresent();
    }

    /**
     * 在数据库中查找手机号为phone的用户是否存在
     * @param phone 手机号
     * @return 存在与否
     */
    @Override
    public boolean isExistedByPhone(String phone) {
        return UserRepo.findUserByPhone(phone).isPresent();
    }
}