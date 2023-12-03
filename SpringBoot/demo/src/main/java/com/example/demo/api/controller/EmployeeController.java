package com.example.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.Customer;
import com.example.demo.api.model.Employee;
import com.example.demo.api.repository.EmployeeRepository;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/add")
	public Employee addNewEmployee(@RequestBody Employee newEmployee){
		employeeRepository.save(newEmployee);
		return newEmployee;
	}

	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee updatedEmployee) {
		String newEmployee = updatedEmployee.getEmpName();

		if (employeeRepository != null) {
			employeeRepository.save(updatedEmployee);
			return newEmployee;
		} else {
			return null;
		}
	}
	@GetMapping("/viewAll")
	public @ResponseBody Iterable<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	@GetMapping("/view/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id){
		return employeeRepository.findById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		updateEmployee.setAddress(employeeDetails.getAddress());
		updateEmployee.setDept(employeeDetails.getDept());
		updateEmployee.setEmpName(employeeDetails.getEmpName());
		updateEmployee.setPhoNo(employeeDetails.getPhoNo());
		employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
	}
	@GetMapping("/search") 
	public ResponseEntity<Employee> searchUsers(@RequestParam("name") Employee name) { 
		return ResponseEntity.ok(name); 
	} 
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		employeeRepository.deleteById(id);
		return "Employee has been Successfully deleted..";
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllCustomers() {
		employeeRepository.deleteAll();
		return ResponseEntity.ok("All customers have been successfully deleted!");
	}

	//	@GetMapping("/hello")
	//	public ResponseEntity<String> getName() {
	//		return  ResponseEntity.ok("Hello, World");
	//	}

	//	@GetMapping("/{userId}") 
	//	public ResponseEntity<String> getUserDetails(@PathVariable String userId) { 
	//		return ResponseEntity.ok(userId); 
	//	} 

} 
