package com.expr.bookstore.controllers;


import com.expr.bookstore.entity.User;
import com.expr.bookstore.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Check user`s login info, then create a jwt token returned to front end
     * @return jwt token
     */

    @PostMapping(path = "/login")
    public @ResponseBody
    Map login(@RequestParam String username, @RequestParam String password) throws ServletException {
        if (username == "" || password == "")
            throw new ServletException("Please fill in username and password");
        // Create Twt token
        String jwtToken = Jwts.builder().setSubject(username).claim("roles", "member").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("message", "login success");
        map.put("token", jwtToken);
        return map;
    }

    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @param phone    手机号
     * @param email    邮箱
     * @param address  地址
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
     *
     * @param username 用户名
     * @return 用户
     */
    @PostMapping(path = "/getUserByUsername")
    public @ResponseBody
    User getUserByUsername(@RequestParam String username) {
        return userService.queryUserByUsername(username);
    }

}