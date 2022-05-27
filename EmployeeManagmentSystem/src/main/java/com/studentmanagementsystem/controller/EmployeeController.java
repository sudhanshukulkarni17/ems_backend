package com.studentmanagementsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.exception.ResourceNotFoundException;
import com.studentmanagementsystem.model.Employee;
import com.studentmanagementsystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//get all the employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	//create employee
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) 
	{
			return employeeRepository.save(employee);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		
		Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with this id is not found: " + id));
		return ResponseEntity.ok(employee);
	}
	
	//update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		
		Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with this id is not found: " + id));
		
		System.out.println(employeeDetails.toString());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());
		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
		
	}
	
	//delete the employees 
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee doesn't exist with the id:" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
