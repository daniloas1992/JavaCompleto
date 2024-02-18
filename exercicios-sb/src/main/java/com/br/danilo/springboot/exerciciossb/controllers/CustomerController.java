package com.br.danilo.springboot.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.danilo.springboot.exerciciossb.models.Customer;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	
	@GetMapping(path = "/some")
	public Customer getCustomer() {
		return new Customer(28, "John", "123.456.789-01");
		
	}

}
