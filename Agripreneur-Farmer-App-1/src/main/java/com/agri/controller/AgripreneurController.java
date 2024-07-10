package com.agri.controller;

import com.agri.dto.AgripreneurRegistrationDto;
import com.agri.dto.AuthenticateRequest;
import com.agri.dto.LoginRequest;
import com.agri.dto.VerifyRequest;
import com.agri.model.Agripreneur;
import com.agri.service.AgripreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/agripreneurs")
@Validated
public class AgripreneurController {

    @Autowired
    private AgripreneurService agripreneurService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerAgripreneur(
            @Valid @ModelAttribute AgripreneurRegistrationDto registrationDto) throws IOException {
        Agripreneur savedAgripreneur = agripreneurService.saveAgripreneur(registrationDto);
        String smsMessage = generateSmsMessage(savedAgripreneur);

        Map<String, Object> response = new HashMap<>();
        response.put("agripreneurId", savedAgripreneur.getAgripreneurId());
        response.put("smsMessage", smsMessage);
        response.put("message", "Registration successful.");

        return ResponseEntity.ok(response);
    }

    
    // login part 
    
    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> authenticateMobileNumber(@RequestBody AuthenticateRequest request) {
        agripreneurService.sendOtpToMobileNumber(request.getMobileNumber());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "OTP sent successfully to " + request.getMobileNumber());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify")
    public ResponseEntity<Map<String, Object>> verifyOTP(@RequestBody VerifyRequest request) {
        boolean isValid = agripreneurService.verifyOtp(request.getMobileNumber(), request.getOtp());
        if (isValid) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "OTP verified successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid OTP"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        try {
            String token = agripreneurService.authenticateAndLogin(request.getMobileNumber(), request.getOtp());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", e.getMessage()));
        }
    }

    private String generateSmsMessage(Agripreneur agripreneur) {
        return "Registration successful. Your ID is: " + agripreneur.getAgripreneurId();
    }
    
    
}
