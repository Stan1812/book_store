package com.expr.bookstore.controllers;


import com.expr.bookstore.entity.User;
import com.expr.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @param phone 手机号
     * @param email 邮箱
     * @param address 地址
     * @return 1
     */
    @PostMapping(path = "/register")
    public @ResponseBody
    User addNewUser(@RequestParam String username, @RequestParam String password,
                   @RequestParam String phone, @RequestParam String email,
                   @RequestParam String address) {
        return userService.addUser(username, password, phone, email, address);
    }

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    @PostMapping(path = "/getUserByUsername")
    public @ResponseBody User getUserByUsername(@RequestParam String username) {
        return userService.queryUserByUsername(username);
    }

//    /**
//     * 通过用户手机号查询用户
//     * @param phone
//     * @return
//     */
//    @GetMapping(path = "/getUserByPhone")
//    public @ResponseBody User getUserByPhone(@RequestParam String phone) {
//        return userService.queryUserByPhone(phone);
//    }
}