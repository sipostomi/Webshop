package com.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webshop.entity.Product;
import com.webshop.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> getProducts(){
		List<Product> products = productRepo.findAll();
		return products;
	}
	
	public void save(Product product) {
		 productRepo.save(product);
	}
	
	 public void delete(long id) {
	    	productRepo.deleteById(id);
	 }
	 
	public Product get(long id) {
        return productRepo.findById(id).get();
    }

}
