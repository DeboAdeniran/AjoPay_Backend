package com.example.ajopayback.service.implement;

import com.example.ajopayback.exception.CustomException;
import com.example.ajopayback.model.User;
import com.example.ajopayback.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerUserDetails(user);
    }
}
