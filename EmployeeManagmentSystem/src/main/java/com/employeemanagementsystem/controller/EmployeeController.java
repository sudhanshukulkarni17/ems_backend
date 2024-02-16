package com.employeemanagementsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employeemanagementsystem.model.book.Book;
import com.employeemanagementsystem.repository.book.BookRepository;
import com.employeemanagementsystem.service.EmployeeService;
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

import com.employeemanagementsystem.exception.ResourceNotFoundException;
import com.employeemanagementsystem.model.employee.Employee;
import com.employeemanagementsystem.repository.employee.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private EmployeeService employeeService;

	
	
	//get all the employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	//create employee
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) 
	{
			return employeeService.createEmployee(employee);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		
		Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with this id is not found: " + id));
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	//update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with this id is not found: " + id));
		return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDetails));
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

	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}













}
