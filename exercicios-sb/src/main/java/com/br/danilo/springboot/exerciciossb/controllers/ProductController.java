package com.br.danilo.springboot.exerciciossb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.danilo.springboot.exerciciossb.model.entities.Product;
import com.br.danilo.springboot.exerciciossb.model.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	/*@PostMapping
	public @ResponseBody Product newProduct(@RequestParam String name, @RequestParam double price, @RequestParam double discount) {
		Product product = new Product(name, price, discount);
		productRepository.save(product);
		return product;
	}*/
	
	/*@PostMapping  // o método "newProduct" e "alterProduct" foram concentrados no método "saveProduct"
	public @ResponseBody Product newProduct(@Valid Product product) {
		productRepository.save(product);
		return product;
	}
	
	@PutMapping
	public Product alterProduct(@Valid Product product) {
		productRepository.save(product);
		return product;
	}*/
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Product saveProduct(@Valid Product product) {
		productRepository.save(product);
		return product;
	}
	
	@GetMapping
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return productRepository.findById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}

}
