package com.br.danilo.springboot.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
	
	@GetMapping("/add/{n1}/{n2}") //http://localhost:8080/calculator/add/10/20
	public int add(@PathVariable int n1, @PathVariable int n2) {
		return n1 + n2;
	}
	
	@GetMapping(path = "/sub") //http://localhost:8080/calculator/sub?n1=10&n2=20
	public int sub(@RequestParam (name = "n1") int n1, @RequestParam (name = "n2") int n2) {
		return n1 - n2;
	}
	
	

}
