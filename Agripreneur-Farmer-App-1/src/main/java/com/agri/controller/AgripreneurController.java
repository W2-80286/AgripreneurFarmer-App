package com.agri.controller;

import com.agri.model.Agripreneur;
import com.agri.service.AgripreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/agripreneurs")
public class AgripreneurController {

    @Autowired
    private AgripreneurService agripreneurService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerAgripreneur(@RequestBody Agripreneur agripreneur) {
        Agripreneur savedAgripreneur = agripreneurService.saveAgripreneur(agripreneur);
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
