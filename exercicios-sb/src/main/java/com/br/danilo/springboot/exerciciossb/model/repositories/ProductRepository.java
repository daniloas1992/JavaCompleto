package com.br.danilo.springboot.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.danilo.springboot.exerciciossb.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//public Iterable<Product> findByNameContaining(String partName); //"findBy" + "name of atribute" + "Contaning"
	
	public Iterable<Product> findByNameContainingIgnoreCase(String partName); //"findBy" + "name of atribute" + "Containing" + "IgnoreCase"
	
	//"Name" é o nome do atributo
	
	//findByNameContaining
	//findByNameIsContaining
	//findByNameContains
	
	//findByNameStartsWith
	//findByNameEndsWith
	
	//findByNameNotContaining
	@Query("SELECT P FROM Product P WHERE P.name LIKE %:name%")
	public Iterable<Product> searchByNameLike(@Param("name") String name);

}
