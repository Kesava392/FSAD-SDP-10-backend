package com.FSAD_SDP_10.library_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.FSAD_SDP_10.library_backend.model.User;
import com.FSAD_SDP_10.library_backend.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000") // React frontend port
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }
}