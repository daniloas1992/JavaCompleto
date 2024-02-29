package com.br.danilo.springboot.exerciciossb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.danilo.springboot.exerciciossb.model.entities.Product;
import com.br.danilo.springboot.exerciciossb.model.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping
	public @ResponseBody Product newProduct(@RequestParam String name, @RequestParam double price, @RequestParam double discount) {
		Product product = new Product(name, price, discount);
		productRepository.save(product);
		return product;
	}

}
