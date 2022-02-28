package com.patika.creditscorems.strategy;

import com.patika.creditscorems.dto.response.CreditResponse;
import com.patika.creditscorems.enumx.CreditResult;

public class Fourth implements Strategy {
    @Override
    public int getLimit(int salary) {
        return salary * 4;
    }

    @Override
    public CreditResponse createResponse(int score, int salary) {
        return new CreditResponse(getLimit(salary), score, CreditResult.CONFIRMED);
    }
}
