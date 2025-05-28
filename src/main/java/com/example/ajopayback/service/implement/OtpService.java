//package com.example.ajopayback.service.implement;
//
//import com.example.ajopayback.dto.request.EmailDetails;
//import com.example.ajopayback.dto.request.OtpRequest;
//import com.example.ajopayback.dto.response.Response;
//import com.example.ajopayback.dto.response.ResponseDto;
//import com.example.ajopayback.model.Otp;
//import com.example.ajopayback.repository.OtpRepository;
//import com.example.ajopayback.service.EmailService;
//import com.example.ajopayback.util.AppUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.time.LocalDateTime;
//
//@Slf4j
//public class OtpService {
//
////    private static final Logger
//    private final OtpRepository otpRepository;
//    private final EmailService emailService;
//
//    public OtpService(OtpRepository otpRepository, EmailService emailService) {
//        this.otpRepository = otpRepository;
//        this.emailService = emailService;
//    }
//
//    public Response sendOTP(OtpRequest otpRequest){
//        Otp existingOTP = otpRepository.findByEmail(otpRequest.getEmail());
//        if (existingOTP != null){
//            otpRepository.delete(existingOTP);
//        }
//        String otp = AppUtils.generateOTP();
//        log.info("otp: {}",otp);
//        otpRepository.save(Otp.builder()
//                        .email(otpRequest.getEmail())
//                        .otp(otp)
//                        .expireAT(LocalDateTime.now().plusMinutes(2))
//                .build());
//        emailService.sendEmailAlert(EmailDetails.builder()
//                .subject(" Your OTP")
//                .recipient(otpRequest.getEmail())
//                .messageBody("This is your OTP, this otp expires in 2 minutes  " + otp)
//                .build());
//        return Response.builder()
//                .statusCode(200)
//                .responseMessage("SUCCESS")
//                .build();
//
//    }
//
//    public Response validateOtp(OtpValida)
//}
