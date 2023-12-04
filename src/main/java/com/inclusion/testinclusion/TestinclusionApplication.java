package com.inclusion.testinclusion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestinclusionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestinclusionApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("Test Inclusion - Spring Boot")
						.version("1.0.0")
						.description("Prueba técnica para la empresa Inclusion con Spring Boot.")
						.termsOfService("http://swagger.io/terms/")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")));
	}

}