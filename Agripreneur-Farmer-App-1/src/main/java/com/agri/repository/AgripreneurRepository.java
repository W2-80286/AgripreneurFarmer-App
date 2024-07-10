package com.agri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agri.model.Agripreneur;
import java.util.List;


public interface AgripreneurRepository extends JpaRepository<Agripreneur, Long> {
	
List<Agripreneur> findByMobileNumber(String mobileNumber);    
}
