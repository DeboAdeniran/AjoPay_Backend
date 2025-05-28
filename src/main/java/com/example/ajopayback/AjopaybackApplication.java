package com.example.ajopayback;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition
		(
				info = @Info(
						title = "Ajopay saving Application",
						description = "Backend RESTAPI for Ajo pay",
						version = "v1.0",
						contact = @Contact(
								name = "Debo Adeniran",
								email = "raqibadeniran03@gmail.com",
								url = "http://github.com/Ajopay/ajopaybackend.git"
						),
						license = @License(
								name = "Ajopay saving Appilcation",
								url = "http://github.com/Ajopay/ajopaybackend.git"
						)
				),
				externalDocs = @ExternalDocumentation(
						description = "Ajopay Saving Application Documentation",
						url = "http://github.com/Ajopay/ajopaybackend.git"
				)
		)
public class AjopaybackApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		SpringApplication.run(AjopaybackApplication.class, args);
	}

}
