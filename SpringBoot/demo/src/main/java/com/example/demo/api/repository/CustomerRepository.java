package com.example.demo.api.repository;

import com.example.demo.api.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
