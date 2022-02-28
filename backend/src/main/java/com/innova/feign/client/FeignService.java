package com.innova.feign.client;

import com.innova.feign.model.CreditDto;
import com.innova.feign.model.CreditResponse;
import com.innova.feign.model.CreditScoreRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "CREDITSCOREMS", url = "http://localhost:9002/api/v1/credit")
public interface FeignService {

    @PostMapping("/request")
    CreditResponse callCreditResultService(@RequestBody CreditScoreRequest creditScoreRequest);

    @PostMapping("/save")
    void save(@RequestBody CreditDto creditRequest);

}
