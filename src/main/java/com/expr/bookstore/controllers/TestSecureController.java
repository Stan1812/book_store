package com.expr.bookstore.controllers;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class TestSecureController {
    @RequestMapping("/user")
    public Claims loginSuccess(@RequestAttribute Claims claims) {
        return claims;
    }
}