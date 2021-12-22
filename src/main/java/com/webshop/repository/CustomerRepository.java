package com.webshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.webshop.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findAll();
}
