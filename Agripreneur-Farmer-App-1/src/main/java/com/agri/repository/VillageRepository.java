package com.agri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agri.model.Village;

public interface VillageRepository extends JpaRepository<Village, Long> {

}
