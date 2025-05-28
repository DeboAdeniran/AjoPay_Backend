package com.example.ajopayback.service;

import com.example.ajopayback.dto.request.LoginDto;
import com.example.ajopayback.dto.request.Oauth2Request;
import com.example.ajopayback.dto.request.RequestDto;
import com.example.ajopayback.dto.response.AccountNameDto;
import com.example.ajopayback.dto.response.LoginResponseDto;
import com.example.ajopayback.dto.response.ResponseDto;
import com.example.ajopayback.model.User;

public interface UserService {
    public ResponseDto SignUp(RequestDto requestDto);


//    User getUserByFirstName(String firstName);

    User getUserByEmail(String email);

    AccountNameDto getUserByAccountNumber(String accountNumber);

    public LoginResponseDto verify(LoginDto loginDto);

//    LoginResponseDto loginWithGoogle(Oauth2Request oauth2Request);


}
