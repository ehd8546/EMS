package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.domain.entity.Work_Order_T;
import com.ems.domain.repository.Work_Order_T_Repository;

@RequestMapping(value = "/ems")
@RestController
public class EMSController {

	@Autowired
	private Work_Order_T_Repository repo;
	
	@GetMapping(value = "/get")
	public List<Work_Order_T> getAllList() {
		return repo.findAll();
	}
	
	
	@GetMapping(value = "/get/{id}")
	public Work_Order_T getOne(@PathVariable(value = "id") Long WO_NO) {
		Optional<Work_Order_T> one = repo.findById(WO_NO);
		Work_Order_T WOT = one.get();
		return WOT;
	}
	
	@PostMapping("/insert")
	public Work_Order_T insert(@RequestBody Work_Order_T wot) {
		
		return repo.save(wot);
	}
	
	@PutMapping(value = "/get/{id}")
	public Work_Order_T update(@PathVariable(value = "id")
	Long WO_NO, @RequestBody Work_Order_T wotDetails) {
		
		Optional<Work_Order_T> one = repo.findById(WO_NO);
		Work_Order_T wot = one.get();
		
		Work_Order_T update = repo.save(wot);
		return update;
	}
	
	@DeleteMapping(value = "/get/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long WO_NO) {
		Optional<Work_Order_T> one = repo.findById(WO_NO);
		Work_Order_T wot = one.get();
		
		repo.delete(wot);
		
		return ResponseEntity.ok().build();
	}
	

	
}
