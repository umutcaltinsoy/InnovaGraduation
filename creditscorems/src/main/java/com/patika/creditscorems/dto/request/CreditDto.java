package com.patika.creditscorems.dto.request;

import lombok.Data;

@Data
public class CreditDto {
    private String identityNumber;
    private Integer creditScore;
}
