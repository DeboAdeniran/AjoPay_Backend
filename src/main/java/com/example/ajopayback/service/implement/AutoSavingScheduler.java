package com.example.ajopayback.service.implement;


import com.example.ajopayback.model.SavingPlans;
import com.example.ajopayback.model.User;
import com.example.ajopayback.repository.SavingsPlanRepository;
import com.example.ajopayback.repository.UserRepository;
import com.example.ajopayback.service.SavingPlanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutoSavingScheduler {
    @Autowired
    private SavingPlanServices savingPlanServices;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SavingsPlanRepository savingsPlanRepository;

    @Scheduled(cron = "0 0 2 * * ?")
    @Transactional
    public void processAutoSaving() {
        List<SavingPlans> activePlans = savingPlanServices.getActiveSavingPlans();

        for (SavingPlans plan : activePlans) {
            User user = plan.getUser();

            if (plan.isExpired()){
                plan.setActive(false);
                continue;
            }

            if (user != null && plan.getDurationInMonths() >0){
                user.setTotalBalance(user.getTotalBalance() + plan.getAmount());

                plan.setDurationInMonths(plan.getDurationInMonths()-1);
                if (plan.getDurationInMonths()==0){
                    plan.setActive(false);
                }


                savingsPlanRepository.save(plan);
                userRepository.save(user);
            }
        }
    }
}
