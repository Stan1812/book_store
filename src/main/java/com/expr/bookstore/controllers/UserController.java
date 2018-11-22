package com.expr.bookstore.controllers;


import com.expr.bookstore.dao.repository.UserRepository;
import com.expr.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/add")
    public @ResponseBody
    int addNewUser(@RequestParam String username, @RequestParam String password) {
        return userService.addUser(username, password);
    }

    @GetMapping(path = "/existedByUsername")
    public @ResponseBody
    boolean isExistedByUsername(@RequestParam String username) {
        return userService.isExistedByUsername(username);
    }

    @GetMapping(path = "/existedByPhone")
    public @ResponseBody
    boolean isExistedByPhone(@RequestParam String phone) {
        return userService.isExistedByPhone(phone);
    }
}