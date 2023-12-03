package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
