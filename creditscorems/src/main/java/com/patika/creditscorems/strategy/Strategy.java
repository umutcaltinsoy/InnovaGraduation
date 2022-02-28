package com.patika.creditscorems.strategy;

import com.patika.creditscorems.dto.response.CreditResponse;

public interface Strategy {

    int getLimit(int salary);

    CreditResponse createResponse(int score,int salary);
}
