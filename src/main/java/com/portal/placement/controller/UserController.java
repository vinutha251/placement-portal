package com.portal.placement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.placement.model.User;
import com.portal.placement.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestParam String email, 
                        @RequestParam String password) {
        return userService.loginUser(email, password);
    }
}