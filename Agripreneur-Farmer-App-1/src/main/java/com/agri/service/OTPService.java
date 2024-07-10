package com.agri.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;

@Service
public class OTPService {
    
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    @PostConstruct
    private void initTwilio() {
        if (accountSid == null || authToken == null || fromPhoneNumber == null) {
            throw new RuntimeException("Twilio initialization failed: Account SID, Auth Token, or Phone Number is null");
        }
        Twilio.init(accountSid, authToken);
    }

    private Map<String, Integer> otpStorage = new HashMap<>();

    public int generateOTP(String mobileNumber) {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        otpStorage.put(mobileNumber, otp);
        return otp;
    }

    public boolean verifyOTP(String mobileNumber, int otp) {
        Integer storedOTP = otpStorage.get(mobileNumber);

        if (storedOTP != null && storedOTP == otp) {
            otpStorage.remove(mobileNumber);
            return true;
        }
        return false;
    }
}
