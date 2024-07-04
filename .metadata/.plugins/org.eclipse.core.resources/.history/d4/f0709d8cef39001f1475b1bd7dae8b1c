package com.agri.service;

import com.agri.model.Agripreneur;
import com.agri.repository.AgripreneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgripreneurService {

    @Autowired
    private AgripreneurRepository agripreneurRepository;

    public Agripreneur saveAgripreneur(Agripreneur agripreneur) {
        return agripreneurRepository.save(agripreneur);
    }
}
