package com.example.ajopayback.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateVirtualAccountRequest {
    @JsonProperty("pay_va_step")
    private String payvaStep;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("pay_amount")
    private String payAmount;
    @JsonProperty("pay_currency")
    private String payCurrency;

    @JsonProperty("holder_account_type")
    private String holderAccountType;

    @JsonProperty("customer_ref")
    private String customerRef;

    @JsonProperty("pay_ext_ref")
    private String payExtRef;

    public CreateVirtualAccountRequest(String payvaStep, String countryCode, String payAmount, String payCurrency, String holderAccountType, String customerRef, String payExtRef) {
        this.payvaStep = payvaStep;
        this.countryCode = countryCode;
        this.payAmount = payAmount;
        this.payCurrency = payCurrency;
        this.holderAccountType = holderAccountType;
        this.customerRef = customerRef;
        this.payExtRef = payExtRef;
    }

    public String getPayvaStep() {
        return payvaStep;
    }

    public void setPayvaStep(String payvaStep) {
        this.payvaStep = payvaStep;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayCurrency() {
        return payCurrency;
    }

    public void setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency;
    }

    public String getHolderAccountType() {
        return holderAccountType;
    }

    public void setHolderAccountType(String holderAccountType) {
        this.holderAccountType = holderAccountType;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getPayExtRef() {
        return payExtRef;
    }

    public void setPayExtRef(String payExtRef) {
        this.payExtRef = payExtRef;
    }

    @Override
    public String toString() {
        return "CreateVirtualAccountRequest{" +
                "payvaStep='" + payvaStep + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", payCurrency='" + payCurrency + '\'' +
                ", holderAccountType='" + holderAccountType + '\'' +
                ", customerRef='" + customerRef + '\'' +
                ", payExtRef='" + payExtRef + '\'' +
                '}';
    }
}
