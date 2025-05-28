package com.example.ajopayback.service.implement;

import com.example.ajopayback.dto.response.CreateVirtualAccountResponse;
import com.example.ajopayback.dto.request.CreateVirtualAccountRequest;
import com.example.ajopayback.service.PaymentService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentImplementation  implements PaymentService {
    private static final String BASE_URL = "";
    private static final String AUTHORIZATION_TOKEN = "";
    private static final String MONI_SIGNATURE="";
    @Override
    public CreateVirtualAccountResponse createVirtualAccount(CreateVirtualAccountRequest request) {
        RestTemplate restTemplate = new RestTemplate();


        String url = BASE_URL + "";

        HttpEntity<CreateVirtualAccountRequest> entity=new HttpEntity<>(request,headers());


        ResponseEntity<CreateVirtualAccountResponse> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, entity, CreateVirtualAccountResponse.class);

        return responseEntity.getBody();


        
    }
        private HttpHeaders headers(){
            HttpHeaders headers =new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", AUTHORIZATION_TOKEN);
            headers.set("moni_signature", MONI_SIGNATURE);
            return headers;
        }
    }

