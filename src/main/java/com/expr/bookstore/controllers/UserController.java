package com.expr.bookstore.controllers;


import com.expr.bookstore.entity.User;
import com.expr.bookstore.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public @ResponseBody
    Map login(@RequestBody User receiveuser) throws ServletException {
        String username = receiveuser.getUsername();
        String password = receiveuser.getPassword();
        if (username.equals("")  || password.equals(""))
            throw new ServletException("Please fill in username and password");
        User user = userService.queryUserByUsername(username);
        HashMap<String, String> res = new HashMap<String, String>();
        String pass = user.getPassword();
        if (pass.equals(password)) {
            Long id = user.getId();
            // create token
            String jwtToken = Jwts.builder()
                    .setSubject(username)
                    .claim("roles", "member")
                    .setIssuedAt(new Date())
                    .setId(id.toString())
                    .signWith(SignatureAlgorithm.HS256, "secretkey")
                    .compact();
            res.put("message", "login success");
            res.put("token", jwtToken);
        } else {
            res.put("message", "login failed");
            res.put("error", "wrong password");
        }
        return res;
    }

    /**
     * 用户注册
     *
     * @return 1
     */
    @PostMapping(path = "/register")
    public @ResponseBody
    User addNewUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();
        String email = user.getEmail();
        String address = user.getAddress();
        return userService.addUser(username, password, phone, email, address);
    }
    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    @GetMapping(path = "/getUserByUsername")
    public @ResponseBody
    User getUserByUsername(@RequestParam String username) {
        return userService.queryUserByUsername(username);
    }
}