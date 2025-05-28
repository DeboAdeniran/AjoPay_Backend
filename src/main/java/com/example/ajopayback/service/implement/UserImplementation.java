package com.example.ajopayback.service.implement;

import com.example.ajopayback.dto.request.EmailDetails;
import com.example.ajopayback.dto.request.LoginDto;
import com.example.ajopayback.dto.request.Oauth2Request;
import com.example.ajopayback.dto.request.RequestDto;
import com.example.ajopayback.dto.response.AccountNameDto;
import com.example.ajopayback.dto.response.LoginResponseDto;
import com.example.ajopayback.dto.response.ResponseDto;
import com.example.ajopayback.exception.UserNotFoundException;
import com.example.ajopayback.model.User;
import com.example.ajopayback.repository.UserRepository;
import com.example.ajopayback.service.EmailService;
import com.example.ajopayback.service.UserService;
import com.example.ajopayback.util.AccountNumberGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImplementation implements UserService {

    private final UserRepository userRepository;
    private final EmailService  emailService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;

    public UserImplementation(UserRepository userRepository, EmailService emailService, AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;
    }


    @Override
    public ResponseDto SignUp(RequestDto requestDto) {
       if (userRepository.existsByEmail(requestDto.getEmail())){
           ResponseDto responseDto = new ResponseDto();
           responseDto.setMessage("This email already exists");
           return responseDto;
       }

        User user = new User();
        user.setFirstName(requestDto.getFirstName());
        user.setSurName(requestDto.getSurName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(requestDto.getPassword()));
        user.setConfirmPassword(bCryptPasswordEncoder.encode(requestDto.getConfirmPassword()));
        user.setPhoneNumber(requestDto.getPhoneNumber());
        user.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
        user.setAvailableBalance(0.00);
        user.setTotalBalance(0.00);

        User createdUser = userRepository.save(user);

        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(createdUser.getEmail());
        emailDetails.setSubject("Welcome to AjoPay - Start Saving Smartly! ");
        emailDetails.setMessageBody(String.format("""
    Dear %s,
    
    🎉 Thank you for signing up with AjoPay! We're excited to have you on board and help you manage your savings efficiently.
    
    ✅ Save money with trusted groups
    ✅ Track your contributions easily
    ✅ Enjoy a seamless and secure experience
    
    Your account number: %s
    
    If you have any questions, feel free to reply to this email or contact our support team at support@ajopay.com.
    
    Happy Saving! 🚀
    
    Best regards,  
    The AjoPay Team
    """, createdUser.getFirstName(), createdUser.getAccountNumber()));
        emailService.sendEmailAlert(emailDetails);

        return new ResponseDto(createdUser.getEmail(),createdUser.getAccountNumber(),"200 OK");
//        return new ResponseDto("Welcome "+createdUser.getFirstName()+" your account number is ");
    }

//    public User getUserByFirstName(String firstName) {
//        return userRepository.findByFirstName(firstName).orElseThrow(()-> new UserNotFoundException("User with first name "+firstName+" not found"));
//    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    @Override
    public AccountNameDto getUserByAccountNumber(String accountNumber) {
        User user = userRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new UserNotFoundException("User with account number " + accountNumber + " not found"));

        return new AccountNameDto(user.getFirstName(), user.getSurName());
    }

    @Override
    public LoginResponseDto verify(LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );
        if (authenticate.isAuthenticated()){
            User user = userRepository.findByEmail(loginDto.getEmail());
            String jwtToken =  jwtService.generateToken(loginDto);
            return  new LoginResponseDto(user.getEmail(),jwtToken);
        }else {
            throw new UserNotFoundException("Invalid email or password");
        }
    }

//    @Override
//    public LoginResponseDto loginWithGoogle(Oauth2Request oauth2Request) {
//        Google verifier = new
//        return null;
//    }


}
