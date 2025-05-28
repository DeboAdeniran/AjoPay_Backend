package com.example.ajopayback.repository;

import com.example.ajopayback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByFirstName(String username);

    User findByEmail(String email);

    Optional<User> findByAccountNumber(String accountNumber);

    Boolean existsByEmail(String email);

}
