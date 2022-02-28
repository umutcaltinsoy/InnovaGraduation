package com.innova;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "Customer API", version = "2.0", description = "Customer Credit Application and Result API"))
public class BankingProjectInnovapatikaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankingProjectInnovapatikaApplication.class, args);
    }
}
