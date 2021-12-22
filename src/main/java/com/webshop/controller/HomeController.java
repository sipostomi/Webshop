package com.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webshop.entity.Customer;
import com.webshop.entity.Product;
import com.webshop.service.CustomerService;
import com.webshop.service.ProductService;

@Controller
public class HomeController {
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService){
		this.productService = productService;
	}
	
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService){
		this.customerService = customerService;
	}
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "index"; 
	}
	
	@RequestMapping("/index.html")
	public String logo(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "index"; 
	}
	
	@RequestMapping("/cart.html")
	public String cart(@ModelAttribute Customer customer) { 
		return "cart"; 
	}
	
	/* CART SAVE */
	@RequestMapping("/savecustomer") 
	public String cartSave(@ModelAttribute Customer customer) {
		customerService.save(customer);
		return "index";
	}
	
	@RequestMapping("/feltoltesek.html")
	public String feltoltesek(Model model, @ModelAttribute Product product) {
		model.addAttribute("products", productService.getProducts());
		return "feltoltesek"; 
	}
	
	/* PRODUCT SAVE FROM UPLOADS */
	@RequestMapping("/saveproduct")
	public String productSave(@ModelAttribute Product product) {
		productService.save(product);
		return "redirect:/feltoltesek.html";
	}
	
	@RequestMapping("/megrendelesek.html")
	public String megrendelesek(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "megrendelesek"; 
	}
	
	@RequestMapping("/login.html")
	public String login() {
		return "login"; 
	}
	
	/* PRODUCT DELETE*/
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    productService.delete(id);
	    return "redirect:/feltoltesek.html";       
	}
	
	/* CUSTOMER DELETE */
	@RequestMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable(name = "id") int id) {
	    customerService.delete(id);
	    return "redirect:/megrendelesek.html";       
	}
	
	/* PRODUCT EDIT */
	@RequestMapping("/editproduct/{id}")
	public ModelAndView editProduct(@PathVariable(name = "id") int id) {
		 ModelAndView editProductPage = new ModelAndView("editproduct");
		 Product product = productService.get(id);
		 editProductPage.addObject("product", product);
		 productService.delete(id);
		 return editProductPage;
	}
	
	
	/* PRODUCT SAVE AFTER EDIT */
	@RequestMapping("/saveeditproduct")
	public String editProductSave(@ModelAttribute Product product) {
		productService.save(product);
		return "redirect:/feltoltesek.html"; 
	}
	
	/* CUSTOMER DATA EDIT */
	@RequestMapping("/edit/{id}")
	public ModelAndView editCustomer(@PathVariable(name = "id") int id) {
		 ModelAndView editPage = new ModelAndView("editorder");
		 Customer customer = customerService.get(id);
		 editPage.addObject("customer", customer);
		 customerService.delete(id);
		 return editPage;
	}
	
	/* CUSTOMER DATA SAVE AFTER EDIT */
	@RequestMapping("/saveeditcustomer")
	public String editCustomerSave(@ModelAttribute Customer customer) {
		customerService.save(customer);
		return "redirect:/megrendelesek.html"; 
	}
}
