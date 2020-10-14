package com.ems.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.domain.entity.Work_Order_T;

public interface Work_Order_T_Repository extends JpaRepository<Work_Order_T, Long> {

	List<Work_Order_T> findByLINECD(String LINECD);

	
	
}
