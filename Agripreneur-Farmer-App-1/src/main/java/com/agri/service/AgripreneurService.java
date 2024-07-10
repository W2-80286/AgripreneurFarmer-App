package com.agri.service;

import com.agri.dto.AgripreneurRegistrationDto;
import com.agri.model.*;
import com.agri.repository.*;
import com.agri.security.JwtUtil;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgripreneurService {

    @Autowired
    private AgripreneurRepository agripreneurRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private TalukaRepository talukaRepository;

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private AgripreneurImageRepository agripreneurImageRepository;
    
    @Autowired
    private OTPService otpService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void sendOtpToMobileNumber(String mobileNumber) {
        int otp = otpService.generateOTP(mobileNumber);
        // Code to send OTP via SMS (using Twilio or another service)
        try {
            Twilio.init(accountSid, authToken);

            Message message = Message.creator(
                    new PhoneNumber("+1" + mobileNumber), // Adjust for international format if needed
                    new PhoneNumber(fromPhoneNumber),
                    "Your OTP is: " + otp)
                    .create();

            System.out.println("OTP sent successfully to " + mobileNumber);
        } catch (Exception e) {
            System.err.println("Error sending OTP: " + e.getMessage());
            throw new RuntimeException("Failed to send OTP");
        }

    }

    public boolean verifyOtp(String mobileNumber, int otp) {
        return otpService.verifyOTP(mobileNumber, otp);
    }

    public String authenticateAndLogin(String mobileNumber, int otp) {
        if (verifyOtp(mobileNumber, otp)) {
            Agripreneur agripreneur = (Agripreneur) agripreneurRepository.findByMobileNumber(mobileNumber);
            if (agripreneur != null) {
                // Generate JWT token for successful login
                return jwtUtil.generateToken(mobileNumber);
            } else {
                throw new RuntimeException("Agripreneur not found");
            }
        } 
        else 
        {
            throw new RuntimeException("Invalid OTP");
        }
    }
    public void validateAgripreneurRegistration(AgripreneurRegistrationDto registrationDto) {
        if (registrationDto.getCategoryId() == null) {
            throw new IllegalArgumentException("Category ID must not be null");
        }
        if (registrationDto.getStateId() == null) {
            throw new IllegalArgumentException("State ID must not be null");
        }
        if (registrationDto.getDistrictId() == null) {
            throw new IllegalArgumentException("District ID must not be null");
        }
        if (registrationDto.getTalukaId() == null) {
            throw new IllegalArgumentException("Taluka ID must not be null");
        }
        if (registrationDto.getVillageId() == null) {
            throw new IllegalArgumentException("Village ID must not be null");
        }
    }

    public Agripreneur saveAgripreneur(AgripreneurRegistrationDto registrationDto) throws IOException {
        validateAgripreneurRegistration(registrationDto);

        Agripreneur agripreneur = new Agripreneur();
        agripreneur.setName(registrationDto.getName());
        agripreneur.setIdNo(registrationDto.getIdNo());
        agripreneur.setVentureName(registrationDto.getVentureName());
        agripreneur.setServiceCost(registrationDto.getServiceCost());
        agripreneur.setPincode(registrationDto.getPincode());
        agripreneur.setMobileNumber(registrationDto.getMobileNumber());
        agripreneur.setLandlineNumber(registrationDto.getLandlineNumber());
        agripreneur.setEmail(registrationDto.getEmail());
        agripreneur.setNtiName(registrationDto.getNtiName());
        agripreneur.setLatitude(registrationDto.getLatitude());
        agripreneur.setLongitude(registrationDto.getLongitude());
        agripreneur.setRestrictedInfo(registrationDto.getRestrictedInfo());
        agripreneur.setAnnualTurnover(registrationDto.getAnnualTurnover());
        agripreneur.setAnnualIncome(registrationDto.getAnnualIncome());
        agripreneur.setPersonsEmployed(registrationDto.getPersonsEmployed());
        agripreneur.setFarmersCovered(registrationDto.getFarmersCovered());
        agripreneur.setVillagesCovered(registrationDto.getVillagesCovered());
        agripreneur.setBankLoan(registrationDto.getBankLoan());
        agripreneur.setSubsidy(registrationDto.getSubsidy());
        agripreneur.setKeywords(registrationDto.getKeywords());

        // Fetch and set Category
        Optional<Category> optionalCategory = categoryRepository.findById(registrationDto.getCategoryId());
        if (optionalCategory.isPresent()) {
            agripreneur.setServiceCategory(optionalCategory.get());
        } else {
            throw new RuntimeException("Category not found");
        }

        // Fetch and set State
        Optional<State> optionalState = stateRepository.findById(registrationDto.getStateId());
        if (optionalState.isPresent()) {
            agripreneur.setState(optionalState.get());
        } else {
            throw new RuntimeException("State not found");
        }

        // Fetch and set District
        Optional<District> optionalDistrict = districtRepository.findById(registrationDto.getDistrictId());
        if (optionalDistrict.isPresent()) {
            agripreneur.setDistrict(optionalDistrict.get());
        } else {
            throw new RuntimeException("District not found");
        }

        // Fetch and set Taluka
        Optional<Taluka> optionalTaluka = talukaRepository.findById(registrationDto.getTalukaId());
        if (optionalTaluka.isPresent()) {
            agripreneur.setTaluka(optionalTaluka.get());
        } else {
            throw new RuntimeException("Taluka not found");
        }

        // Fetch and set Village
        Optional<Village> optionalVillage = villageRepository.findById(registrationDto.getVillageId());
        if (optionalVillage.isPresent()) {
            agripreneur.setVillage(optionalVillage.get());
        } else {
            throw new RuntimeException("Village not found");
        }

        Agripreneur savedAgripreneur = agripreneurRepository.save(agripreneur);

        // Save images
        if (registrationDto.getImages() != null) {
            List<AgripreneurImage> agripreneurImages = new ArrayList<>();
            for (MultipartFile imageFile : registrationDto.getImages()) {
                AgripreneurImage agripreneurImage = new AgripreneurImage();
                agripreneurImage.setImageData(imageFile.getBytes());
                agripreneurImage.setAgripreneur(savedAgripreneur);
                agripreneurImages.add(agripreneurImage);
            }
            agripreneurImageRepository.saveAll(agripreneurImages);
        }

        return savedAgripreneur;
    }
    
	}

	
