package com.example.ajopayback.controller;

import com.example.ajopayback.dto.request.SavingRequest;
import com.example.ajopayback.model.SavingPlans;
import com.example.ajopayback.service.SavingPlanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SavingsController {
    @Autowired
    private SavingPlanServices savingPlanServices;

    @PostMapping("/create/{userId}")
    public ResponseEntity<String> createSavingPlan(@PathVariable Long userId, @RequestBody SavingRequest request) {
        savingPlanServices.createSavingPlan(userId, request);
        return ResponseEntity.ok("Saving plan created");
    }

    @GetMapping("/active")
    public ResponseEntity<List<SavingPlans>> getActiveSavingPlan() {
        return ResponseEntity.ok(savingPlanServices.getActiveSavingPlans());
    }
}
