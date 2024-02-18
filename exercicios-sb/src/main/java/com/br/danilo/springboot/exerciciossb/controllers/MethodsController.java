package com.br.danilo.springboot.exerciciossb.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methods")
public class MethodsController {
	
	@GetMapping
	public String get() {
		return "Request GET";
	}
	
	@PostMapping
	public String post() {
		return "Request POST";
	}
	
	@PutMapping
	public String put() {
		return "Request PUT";
	}
	
	@PatchMapping
	public String patch() {
		return "Request PACTH";
	}

	@DeleteMapping
	public String delete() {
		return "Request DELETE";
	}

}
