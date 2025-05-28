package com.example.ajopayback.repository;

import com.example.ajopayback.model.SavingPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SavingsPlanRepository extends JpaRepository<SavingPlans, Long> {
    List<SavingPlans> findByActiveTrue();
}
