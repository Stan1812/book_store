package com.expr.bookstore.controllers;


import com.expr.bookstore.entity.User;
import com.expr.bookstore.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    @ResponseBody
    public Map login(@RequestBody User receiveuser) throws ServletException {
        String username = receiveuser.getUsername();
        String password = receiveuser.getPassword();
        if (username.equals("") || password.equals(""))
            throw new ServletException("Please fill in username and password");
        User user = userService.queryUserByUsername(username);
        HashMap<String, Object> res = new HashMap<String, Object>();
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
            res.put("status", 1);
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
    @ResponseBody
    public Map addNewUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();
        String email = user.getEmail();
        String address = user.getAddress();
        Map<String, Object> res = new HashMap<>();
        User adjustUser = userService.queryUserByUsername(username);
        System.out.print(adjustUser);
        if (adjustUser == null) {
            userService.addUser(username, password, phone, email, address);
            res.put("status", 1);
            res.put("message", "注册成功");
        } else {
            res.put("status", 0);
            res.put("message", "用户名已存在");
        }
        return res;
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    @GetMapping(path = "/getUserByUsername")
    @ResponseBody
    public User getUserByUsername(@RequestParam String username) {
        return userService.queryUserByUsername(username);
    }

    /**
     * 是否admin
     */
    @GetMapping(path = "/authAdmin")
    public Map authAdmin(@RequestAttribute Claims claims) {
        Map<String, Object> res = new HashMap<String, Object>();
        Long userId = Long.parseLong(claims.getId());
        User userRes = userService.queryUserById(userId);
        String username = userRes.getUsername();
        if (username.equals("admin")) {
            res.put("status", 1);
            res.put("message", "admin auth success");
        } else {
            res.put("status", 0);
            res.put("message", "no permission");
        }
        return res;
    }

    /**
     * @return 所有用户
     */
    @GetMapping(path = "/allUser")
    public @ResponseBody
    List<User> getAllUser() {
        return userService.findAll();
    }


}