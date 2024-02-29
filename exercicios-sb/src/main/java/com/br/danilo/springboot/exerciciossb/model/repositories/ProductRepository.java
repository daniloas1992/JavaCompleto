package com.br.danilo.springboot.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.danilo.springboot.exerciciossb.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//public Iterable<Product> findByNameContaining(String partName); //"findBy" + "name of atribute" + "Contaning"
	
	public Iterable<Product> findByNameContainingIgnoreCase(String partName); //"findBy" + "name of atribute" + "Containing" + "IgnoreCase"

}
