package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CustomerController {

	
	private final CustomerService cs;
	
//	insted of autowired we can use constructor
	public CustomerController(CustomerService cs) {
		this.cs=cs;
	}
	
	@GetMapping("/")
	public String home() {
		return new String("Hello");
	}
	
	@PostMapping("add")
	public void add(@RequestBody Customer entity) {
		cs.add(entity);
	}

	@GetMapping("display")
	public ResponseEntity<?> display() {
		return ResponseEntity.status(200).body(cs.display()); 
	}
		
	
}
