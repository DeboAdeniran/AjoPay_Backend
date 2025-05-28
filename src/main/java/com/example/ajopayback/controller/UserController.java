package com.example.ajopayback.controller;

import com.example.ajopayback.dto.request.LoginDto;
import com.example.ajopayback.dto.request.RequestDto;
import com.example.ajopayback.dto.response.AccountNameDto;
import com.example.ajopayback.dto.response.LoginResponseDto;
import com.example.ajopayback.dto.response.ResponseDto;
import com.example.ajopayback.model.User;
import com.example.ajopayback.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseDto SignUp(@RequestBody RequestDto requestDto) {
        return userService.SignUp(requestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto){
        LoginResponseDto responseDto =  userService.verify(loginDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUsers(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

@GetMapping("/by-account/{accountNumber}")
    public ResponseEntity<AccountNameDto> getUserByAccountNumber(@PathVariable String accountNumber) {
        AccountNameDto accountNameDto = userService.getUserByAccountNumber(accountNumber);
        return ResponseEntity.ok(accountNameDto);
}


}
