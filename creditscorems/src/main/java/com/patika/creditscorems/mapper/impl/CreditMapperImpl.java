package com.patika.creditscorems.mapper.impl;

import com.patika.creditscorems.dto.request.CreditDto;
import com.patika.creditscorems.entity.Credit;
import com.patika.creditscorems.mapper.CreditMapper;
import org.springframework.stereotype.Component;

@Component
public class CreditMapperImpl implements CreditMapper {

    @Override
    public Credit creditDTOtoCredit(CreditDto customerDto) {

        return Credit.builder()
                .identityNumber(customerDto.getIdentityNumber())
                .creditScore(customerDto.getCreditScore())
                .build();
    }
}
