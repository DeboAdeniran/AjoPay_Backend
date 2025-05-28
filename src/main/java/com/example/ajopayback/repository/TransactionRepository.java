package com.example.ajopayback.repository;

import com.example.ajopayback.model.Transaction;
import com.example.ajopayback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
