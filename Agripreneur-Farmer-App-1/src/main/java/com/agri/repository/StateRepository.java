package com.agri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agri.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
