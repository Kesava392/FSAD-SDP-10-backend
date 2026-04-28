package com.FSAD_SDP_10.library_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FSAD_SDP_10.library_backend.model.User;
import com.FSAD_SDP_10.library_backend.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // Register user
    public String register(User user) {
        if (repo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }
        repo.save(user);
        return "User Registered Successfully";
    }

    // Login user
    public String login(String username, String password) {
        Optional<User> optionalUser = repo.findByUsername(username);

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.get();
        return user.getPassword().equals(password) ? "Login Successful" : "Invalid Password";
    }
}