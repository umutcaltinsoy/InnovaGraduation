package com.innova.feign.model;

import lombok.Data;

@Data
public class CreditDto {
    private String identityNumber;
    private Integer creditScore;
}
