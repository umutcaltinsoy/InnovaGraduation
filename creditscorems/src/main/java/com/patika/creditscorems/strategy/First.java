package com.patika.creditscorems.strategy;

import com.patika.creditscorems.dto.response.CreditResponse;
import com.patika.creditscorems.enumx.CreditResult;

public class First implements Strategy {
    @Override
    public int getLimit(int salary) {
        return 0;
    }

    @Override
    public CreditResponse createResponse(int score,int salary) {
        return new CreditResponse(getLimit(salary),score,CreditResult.UNCONFIRMED);
    }
}
