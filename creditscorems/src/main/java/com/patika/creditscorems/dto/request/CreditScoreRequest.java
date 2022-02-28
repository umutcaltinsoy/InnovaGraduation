package com.patika.creditscorems.dto.request;

import lombok.Data;

@Data
public class CreditScoreRequest {
    private String identityNumber;
    private Integer salary;
}
