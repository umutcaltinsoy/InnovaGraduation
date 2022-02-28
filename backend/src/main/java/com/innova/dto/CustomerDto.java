package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private String identityNumber;
    private String customerName;
    private String customerSurname;
    private Integer customerSalary;
    private String customerPhoneNumber;
}
