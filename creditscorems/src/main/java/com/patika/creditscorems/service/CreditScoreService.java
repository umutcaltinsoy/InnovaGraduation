package com.patika.creditscorems.service;

import com.patika.creditscorems.dto.request.CreditDto;
import com.patika.creditscorems.dto.request.CreditScoreRequest;
import com.patika.creditscorems.dto.response.CreditResponse;

public interface CreditScoreService {
    CreditResponse getCustomerBy(CreditScoreRequest creditScoreRequest);
    void save(CreditDto creditRequest);
}
