package com.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webshop.entity.Customer;
import com.webshop.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	public List<Customer> getCustomers(){
		List<Customer> customers = customerRepo.findAll();
		return customers;
	}
	
	public void save(Customer customer) {
		 customerRepo.save(customer);
	}
	
	public void delete(long id) {
    	customerRepo.deleteById(id);
    }
	
	public Customer get(long id) {
        return customerRepo.findById(id).get();
    }
}
