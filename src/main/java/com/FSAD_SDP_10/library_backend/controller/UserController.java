package com.FSAD_SDP_10.library_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FSAD_SDP_10.library_backend.model.User;
import com.FSAD_SDP_10.library_backend.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService service;

    // Hardcoded admin credentials
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "dkk";

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            String message = service.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        // 1. Check if login is admin
        if (ADMIN_USERNAME.equals(user.getUsername()) && ADMIN_PASSWORD.equals(user.getPassword())) {
            return ResponseEntity.ok("Admin Login Successful");
        }

        // 2. Otherwise check database users
        String message = service.login(user.getUsername(), user.getPassword());
        if (message.equals("Login Successful")) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
        }
    }
}