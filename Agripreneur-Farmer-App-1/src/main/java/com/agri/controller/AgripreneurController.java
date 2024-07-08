package com.agri.controller;

import com.agri.dto.AgripreneurRegistrationDto;
import com.agri.model.Agripreneur;
import com.agri.service.AgripreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    private String generateSmsMessage(Agripreneur agripreneur) {
        return "Registration successful. Your ID is: " + agripreneur.getAgripreneurId();
    }
}
