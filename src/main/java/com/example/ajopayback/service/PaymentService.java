package com.example.ajopayback.service;

import com.example.ajopayback.dto.response.CreateVirtualAccountResponse;
import com.example.ajopayback.dto.request.CreateVirtualAccountRequest;

public interface PaymentService {
    public CreateVirtualAccountResponse createVirtualAccount(CreateVirtualAccountRequest request);
}
