package com.example.ajopayback.service.implement;

import com.example.ajopayback.dto.request.EmailDetails;
import com.example.ajopayback.dto.request.TransferRequest;
import com.example.ajopayback.enums.TransactionStatus;
import com.example.ajopayback.model.Transaction;
import com.example.ajopayback.model.User;
import com.example.ajopayback.repository.TransactionRepository;
import com.example.ajopayback.repository.UserRepository;
import com.example.ajopayback.service.EmailService;
import com.example.ajopayback.service.TransferService;
import com.example.ajopayback.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferServiceImplementation implements TransferService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public String transferMoney(TransferRequest request) {

        User sender = userRepository.findByAccountNumber(request.getSenderAccount()).orElseThrow(() -> new RuntimeException("Sender account not found"));
        User reciever = userRepository.findByAccountNumber(request.getReceiverAccount()).orElseThrow(() -> new RuntimeException("Receiver account not found"));

        User user = new User();
        if(sender.getAvailableBalance() < request.getAmount()) {
            throw new RuntimeException("Insufficient funds");
        }

        sender.setAvailableBalance(sender.getAvailableBalance() - request.getAmount());
//        sender.setTotalBalance(sender.getTotalBalance() - request.getAmount());
        reciever.setAvailableBalance(reciever.getAvailableBalance() + request.getAmount());

       User createdUser = userRepository.save(sender);
        User recieverUser = userRepository.save(reciever);

        Transaction transaction = new Transaction();
        transaction.setSenderAccount(sender.getAccountNumber());
        transaction.setReceiverAccount(reciever.getAccountNumber());
        transaction.setAmount(request.getAmount());
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setDescription(request.getDescription());

        Transaction transactionDetails = transactionRepository.save(transaction);

        String recieptPath = PdfGenerator.generateTransferReceipt(transaction, sender, reciever);

        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(createdUser.getEmail());
        emailDetails.setSubject("Transfer successful");
        emailDetails.setMessageBody("Dear "+ createdUser.getFirstName()+" "+createdUser.getSurName()+",\n\n"
        +"Your transfer of ₦"+transactionDetails.getAmount()+" is successful. Your available balance is ₦"+createdUser.getAvailableBalance()+".\n\n"
        +"Transfer Details:\n"
        +"Name:"
        +recieverUser.getFirstName()+" "+recieverUser.getSurName()+"\n"
        +"Bank:\n AjoPay\n"
        +"AccountNumber:\n"
        +recieverUser.getAccountNumber()+"\n"
        +"Amount:\n"
        +"₦"+transaction.getAmount()+"\n"
        +"Date:\n"
        +transaction.getTimestamp()+"\n\n"
        +"For further enquiries, please contact our customer support through the following channels:\n"
        +"Email: support@ajopay.com\n Phone: +123456789\n\nThank you for choosing AjoPay");
        emailService.sendEmailAlert(emailDetails);

        EmailDetails recieverEmailDetails = new EmailDetails();
        recieverEmailDetails.setRecipient(recieverUser.getEmail());
        recieverEmailDetails.setSubject("CREDIT ALERT!!!");
        recieverEmailDetails.setMessageBody("Dear " + recieverUser.getFirstName() + " " + recieverUser.getSurName() + ",\n\n"
                + "We wish to inform you that a CREDIT transaction occurred on your account with us. "
                + "Your transfer of ₦" + transactionDetails.getAmount() + " is successful. Your available balance is ₦" + createdUser.getAvailableBalance() + ".\n\n"
                + "Transfer Details:\n\n"
                + "Name: " + createdUser.getFirstName() + " " + createdUser.getSurName() + "\n"
                + "Bank: AjoPay\n"
                + "Account Number: " + createdUser.getAccountNumber() + "\n"
                + "Amount: ₦" + transaction.getAmount() + "\n"
                + "Description: " + transaction.getDescription() + "\n"
                + "Date: " + transaction.getTimestamp() + "\n\n"
                + "For further enquiries, please contact our customer support through the following channels:\n"
                + "Email: support@ajopay.com\n"
                + "Phone: +123456789\n\n"
                + "Thank you for choosing AjoPay."
        );
        emailService.sendEmailAlert(recieverEmailDetails);

        return "Transfer successful" + recieptPath;
    }
}
