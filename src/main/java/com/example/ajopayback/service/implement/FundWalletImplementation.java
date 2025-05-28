package com.example.ajopayback.service.implement;

import com.example.ajopayback.dto.request.EmailDetails;
import com.example.ajopayback.dto.request.FundWalletRequest;
import com.example.ajopayback.enums.FundWalletStatus;
import com.example.ajopayback.model.FundWallet;
import com.example.ajopayback.model.User;
import com.example.ajopayback.repository.FundWalletRepository;
import com.example.ajopayback.repository.UserRepository;
import com.example.ajopayback.service.EmailService;
import com.example.ajopayback.service.FundWalletInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FundWalletImplementation implements FundWalletInterface {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FundWalletRepository fundWalletRepository;

    @Override
    public String fundWallet(FundWalletRequest request){
        User sender = userRepository.findByAccountNumber((request.getSenderAccount()))
                .orElseThrow(() -> new RuntimeException("Sender Account Not Found"));

        User reciever = userRepository.findByAccountNumber(request.getRecipientAccount())
                .orElseThrow(() -> new RuntimeException("Recipient Account Not Found"));

        if(sender.getAvailableBalance()<request.getAmount()){
            throw new RuntimeException("Insufficient Funds");
        }

        sender.setAvailableBalance(sender.getAvailableBalance() - request.getAmount());
//        sender.setTotalBalance(sender.getTotalBalance() - request.getAmount());
        reciever.setAvailableBalance(reciever.getAvailableBalance() + request.getAmount());
        User senderEmail = userRepository.save(sender);
        User recieverEmail = userRepository.save(reciever);


        FundWallet fundWallet = new FundWallet();
        fundWallet.setSenderAccount(request.getSenderAccount());
        fundWallet.setSenderBank(request.getSenderBank());
        fundWallet.setAmount(request.getAmount());
        fundWallet.setRecepientAccount(request.getRecipientAccount());
        fundWallet.setTimestamp(LocalDateTime.now());
        fundWallet.setStatus(FundWalletStatus.SUCCESS);

        fundWalletRepository.save(fundWallet);

        EmailDetails senderEmailDetails = new EmailDetails();
        senderEmailDetails.setRecipient(senderEmail.getEmail());
        senderEmailDetails.setSubject("Request to fund AjoPay");
        senderEmailDetails.setMessageBody("Your account with us from AjoPay "+recieverEmail.getAccountNumber()+"\n"
        +" request for ₦"+fundWallet.getAmount()+"\n\n"
        +"This your OTP \n"
        +"****\n\n"
        +"DO NOT DISCLOSURE YOUR OTP UNDER ANY CIRCUMSTANCE\n\n\n"
        +"DETAILS:"
        +"Account number: "+recieverEmail.getAccountNumber()+"\n");
        emailService.sendEmailAlert(senderEmailDetails);



        EmailDetails recieverEmailDetails = new EmailDetails();
        recieverEmailDetails.setRecipient(recieverEmail.getEmail());
        recieverEmailDetails.setSubject("FundWallet Notification");
        recieverEmailDetails.setMessageBody("Fundwallet notification for ₦"+fundWallet.getAmount()
        +" is successful your balance is ₦"+recieverEmail.getAvailableBalance()+".\n\n"
        + "DETAILS:\n"
        +"Account name: "+recieverEmail.getFirstName()+" "+recieverEmail.getSurName()+"\n"
        +"Account number: "+recieverEmail.getAccountNumber()+"\n"
        +"Account Balance: ₦"+recieverEmail.getAvailableBalance());
        emailService.sendEmailAlert(recieverEmailDetails);

        return  "Fund Wallet is successfully ";
    }
}
