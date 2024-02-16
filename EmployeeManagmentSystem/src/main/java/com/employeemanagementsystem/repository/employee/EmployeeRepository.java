package com.employeemanagementsystem.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.model.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}
