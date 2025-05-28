package com.example.ajopayback.controller;

import com.example.ajopayback.dto.response.CreateVirtualAccountResponse;
import com.example.ajopayback.dto.request.CreateVirtualAccountRequest;
import com.example.ajopayback.service.PaymentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/payment")
@RequestMapping
public class PaymentController{
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public CreateVirtualAccountResponse createVirtualAccount(@RequestBody CreateVirtualAccountRequest request) {
        return paymentService.createVirtualAccount(request);
    }
}
