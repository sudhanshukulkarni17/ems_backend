package com.studentmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagementsystem.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}
