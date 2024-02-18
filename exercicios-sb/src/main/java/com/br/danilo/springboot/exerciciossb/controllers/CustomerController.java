package com.br.danilo.springboot.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.danilo.springboot.exerciciossb.models.Customer;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	
	@GetMapping(path = "/some")
	public Customer getCustomer() {
		return new Customer(28, "John", "123.456.789-01");
		
	}
	
	@GetMapping("/{id}") // Na URL fica: http://localhost:8080/customers/123
	public Customer getCustomerById(@PathVariable int id) {
		return new Customer(id, "Jhonnas", "123.45.789-02");
	}
	
	@GetMapping  // Na URL fica: http://localhost:8080/customers?id=123
	public Customer getCustomerById2(@RequestParam(name = "id") int id) {
		return new Customer(id, "Augustus", "123.45.789-03");
	}

}
