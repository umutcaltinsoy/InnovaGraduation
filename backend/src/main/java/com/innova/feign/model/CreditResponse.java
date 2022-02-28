package com.innova.feign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditResponse {
    private Integer creditLimit;
    private Integer creditScore;
    private CreditResult creditResult;
}
