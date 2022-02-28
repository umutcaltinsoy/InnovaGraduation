package com.patika.creditscorems;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "Credit Result API", version = "2.0", description = "Customer Credit Result API"))
public class CreditScoreMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditScoreMsApplication.class, args);
    }

}
