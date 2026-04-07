package com.FSAD_SDP_10.library_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.FSAD_SDP_10.library_backend.model.User;

// Repository interface for User entity
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by username
    User findByUsername(String username);

    // Optional: find user by email if needed
    User findByEmail(String email);
}