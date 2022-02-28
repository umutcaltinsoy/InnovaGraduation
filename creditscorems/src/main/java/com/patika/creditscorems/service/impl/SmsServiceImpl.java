package com.patika.creditscorems.service.impl;

import com.patika.creditscorems.service.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Value("${twilio.username}")
    private String userName;

    @Value("${twilio.password}")
    private String password;

    @Override
    public void sendSms(String phoneNumber, String creditResultMessage) {
        Twilio.init(userName, password);
        Message.creator(new PhoneNumber(phoneNumber),
                        new PhoneNumber("+19108282510"), creditResultMessage)
                .create();
    }
}
