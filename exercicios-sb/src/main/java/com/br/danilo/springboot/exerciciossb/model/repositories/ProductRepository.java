package com.br.danilo.springboot.exerciciossb.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.danilo.springboot.exerciciossb.model.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
