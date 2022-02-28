package com.patika.creditscorems.service.impl;

import com.patika.creditscorems.dto.request.CreditDto;
import com.patika.creditscorems.dto.request.CreditScoreRequest;
import com.patika.creditscorems.dto.response.CreditResponse;
import com.patika.creditscorems.entity.Credit;
import com.patika.creditscorems.mapper.CreditMapper;
import com.patika.creditscorems.strategy.*;
import com.patika.creditscorems.repository.CreditRepository;
import com.patika.creditscorems.service.CreditScoreService;
import com.patika.creditscorems.service.SmsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditScoreServiceImpl implements CreditScoreService {

    private final CreditRepository creditRepository;
    private final CreditMapper creditMapper;
    private final SmsService smsService;


    @Override
    public CreditResponse getCustomerBy(CreditScoreRequest creditScoreRequest) {
        Optional<Credit> credit = creditRepository.findByIdentityNumber(creditScoreRequest.getIdentityNumber()); // OKU

        if (credit.isEmpty()) {
            Credit newCredit = Credit.builder().creditScore(generateCreditScore()).identityNumber(creditScoreRequest.getIdentityNumber()).build();
            creditRepository.save(newCredit);

            CreditResponse creditResponse = generateResponse(newCredit, creditScoreRequest.getSalary());
            log.info("Credit result sending via SMS...");
            smsService.sendSms("+905057717336", creditResponse.toString());
            log.info("Credit result sending...");
            return creditResponse;
        }
        return generateResponse(credit.get(), creditScoreRequest.getSalary());
    }

    @Override
    public void save(CreditDto creditDto) {
        Credit credit = creditMapper.creditDTOtoCredit(creditDto);
        creditRepository.save(credit);
    }


    // STRATEGY PATTERN
    private CreditResponse generateResponse(Credit credit, Integer salary) {
        CreditResponse creditResponse = new CreditResponse();
        Context context;
        if (credit.getCreditScore() < 500) {
            context = new Context(new First());
            creditResponse = context.executeStrategy(credit.getCreditScore(), 0);
        } else if ((credit.getCreditScore() >= 500) && (credit.getCreditScore() < 1000) && salary < 5000) {
            context = new Context(new Second());
            creditResponse = context.executeStrategy(credit.getCreditScore(), 0);
        } else if ((credit.getCreditScore() >= 500) && (credit.getCreditScore() < 1000) && salary >= 5000) {
            context = new Context(new Third());
            creditResponse = context.executeStrategy(credit.getCreditScore(), 0);
        } else if ((credit.getCreditScore() >= 1000) && salary >= 5000) {
            context = new Context(new Fourth());
            creditResponse = context.executeStrategy(credit.getCreditScore(), salary);
        }
        return creditResponse;
    }

    private Integer generateCreditScore() {
        return new Random().nextInt(2000);
    }

}

