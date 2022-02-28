package com.patika.creditscorems.service;

public interface SmsService {
    void sendSms(String phoneNumber, String creditResultMessage);
}
