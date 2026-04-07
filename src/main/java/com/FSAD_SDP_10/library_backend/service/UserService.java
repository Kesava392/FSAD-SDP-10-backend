package com.FSAD_SDP_10.library_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FSAD_SDP_10.library_backend.model.User;
import com.FSAD_SDP_10.library_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // Register
    public String register(User user) {
        if (repo.findByUsername(user.getUsername()) != null) {
            return "User already exists!";
        }
        repo.save(user);
        return "User Registered Successfully";
    }

    // Login
    public String login(String username, String password) {
        User user = repo.findByUsername(username);

        if (user == null) {
            return "User not found";
        }

        if (user.getPassword().equals(password)) {
            return "Login Successful";
        } else {
            return "Invalid Password";
        }
    }
}