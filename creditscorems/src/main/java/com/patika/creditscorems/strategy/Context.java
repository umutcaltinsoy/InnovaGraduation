package com.patika.creditscorems.strategy;

import com.patika.creditscorems.dto.response.CreditResponse;

public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public CreditResponse executeStrategy(int score, int salary) {
        return strategy.createResponse(score, salary);
    }
}
