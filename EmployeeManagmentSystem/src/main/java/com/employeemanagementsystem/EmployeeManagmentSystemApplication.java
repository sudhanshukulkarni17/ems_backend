package com.employeemanagementsystem;

import com.employeemanagementsystem.model.book.Book;
import com.employeemanagementsystem.model.employee.Employee;
import com.employeemanagementsystem.repository.book.BookRepository;
import com.employeemanagementsystem.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EmployeeManagmentSystemApplication {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostConstruct
	public void addData2DB(){
		employeeRepository.saveAll(Stream.of(new Employee(5,"trialEmployee", "trialEmployee", "trialEmailId", 123, 12 )).collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(1, "trialBook", "trialAuthor")).collect(Collectors.toList()));
	}


	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagmentSystemApplication.class, args);
	}

}
