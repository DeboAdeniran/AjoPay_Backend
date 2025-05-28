package com.example.ajopayback.service.implement;

import com.example.ajopayback.dto.request.SavingRequest;
import com.example.ajopayback.exception.UserNotFoundException;
import com.example.ajopayback.model.SavingPlans;
import com.example.ajopayback.model.User;
import com.example.ajopayback.repository.SavingsPlanRepository;
import com.example.ajopayback.repository.UserRepository;
import com.example.ajopayback.service.SavingPlanServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingPlanServiceImplementation implements SavingPlanServices {
    @Autowired
    private SavingsPlanRepository savingsPlanRepository;

    @Autowired
    private UserRepository userRepository;
    @Transactional
    @Override
    public SavingPlans createSavingPlan(Long userId, SavingRequest request) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User user = userOpt.get();
        SavingPlans savingPlans = new SavingPlans();
        savingPlans.setUser(user);
        savingPlans.setExternalAccountNumber(request.getExternalAccountNumber());
        savingPlans.setAmount(request.getAmount());
        savingPlans.setStartDate(request.getStartDate());
        savingPlans.setSavingTime(request.getSavingTime());
        savingPlans.setDurationInMonths(request.getDurationInMonths());

        return savingsPlanRepository.save(savingPlans);
    }


    @Override
    public List<SavingPlans> getActiveSavingPlans() {
        return savingsPlanRepository.findByActiveTrue();
    }
}
