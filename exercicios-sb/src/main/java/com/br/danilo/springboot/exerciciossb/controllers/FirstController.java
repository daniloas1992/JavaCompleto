package com.br.danilo.springboot.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	//@RequestMapping(method = RequestMethod.GET, path = "/ola")
	//@GetMapping(path = "/ola")
	@GetMapping(path = {"/ola", "/saudacao"}) // Mais de uma URL para para o mesmo método
	public String ola() {
		return "Hello!";
	}

}
