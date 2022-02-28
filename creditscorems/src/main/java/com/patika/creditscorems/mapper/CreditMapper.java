package com.patika.creditscorems.mapper;

import com.patika.creditscorems.dto.request.CreditDto;
import com.patika.creditscorems.entity.Credit;


public interface CreditMapper {
    Credit creditDTOtoCredit(CreditDto customerDto);
}
