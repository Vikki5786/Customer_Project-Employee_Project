package com.example.demo.api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.api.model.Customer;
import com.example.demo.api.repository.CustomerRepository;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/add")
	public Customer addNewCustomer(@RequestBody Customer newCustomer) {
	    return customerRepository.save(newCustomer);
	}
	
	@GetMapping("/viewAll")
	public @ResponseBody Iterable<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@GetMapping("view/{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		return customerRepository.findById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		customerRepository.deleteById(id); 
		return "Customer has been successfully deleted!";
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllCustomers() {
	    customerRepository.deleteAll();
	    return ResponseEntity.ok("All customers have been successfully deleted!");
	}
	
}
