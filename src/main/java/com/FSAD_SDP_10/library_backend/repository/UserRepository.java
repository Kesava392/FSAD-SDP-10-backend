package com.FSAD_SDP_10.library_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.FSAD_SDP_10.library_backend.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}