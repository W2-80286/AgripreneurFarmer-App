package com.agri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agri.model.District;

public interface DistrictRepository extends JpaRepository<District, Long> {

}
