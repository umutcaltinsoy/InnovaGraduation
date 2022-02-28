package com.patika.creditscorems.controller;

import com.patika.creditscorems.dto.request.CreditDto;
import com.patika.creditscorems.dto.request.CreditScoreRequest;
import com.patika.creditscorems.dto.response.CreditResponse;
import com.patika.creditscorems.service.CreditScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credit")
@Log4j2
public class CreditScoreController {

    private final CreditScoreService creditScoreService;

    @PostMapping("/request")
    public CreditResponse process(@RequestBody CreditScoreRequest creditScoreRequest) {
        log.info("Credit Score Request processing..." + creditScoreRequest);
        return creditScoreService.getCustomerBy(creditScoreRequest);
    }

    @PostMapping("/save")
    public void save(@RequestBody CreditDto creditRequest) {
        log.info("Test data saving..");
        creditScoreService.save(creditRequest);
    }

}
