package com.webshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.webshop.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
}


