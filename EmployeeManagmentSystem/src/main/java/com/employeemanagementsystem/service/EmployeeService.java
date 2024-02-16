package com.employeemanagementsystem.service;

import com.employeemanagementsystem.exception.ResourceNotFoundException;
import com.employeemanagementsystem.model.employee.Employee;
import com.employeemanagementsystem.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.getById(id);
    }

    public Employee updateEmployee (Long id, Employee employee)
    {
        Employee updateEmployee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with this id is not found: " + id));

        System.out.println(employee.toString());
        updateEmployee.setEmailId(employee.getEmailId());
        updateEmployee.setFirstname(employee.getFirstname());
        updateEmployee.setLastname(employee.getLastname());
        employeeRepository.save(updateEmployee);
        return updateEmployee;
    }


}
