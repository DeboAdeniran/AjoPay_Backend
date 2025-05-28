package com.example.ajopayback.service;

import com.example.ajopayback.dto.request.SavingRequest;
import com.example.ajopayback.model.SavingPlans;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SavingPlanServices {
    SavingPlans createSavingPlan( Long userId, SavingRequest request);

    List<SavingPlans> getActiveSavingPlans();
}
