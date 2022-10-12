package com.present.springema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.present.springema.repository.EmployeeRepository;
import com.present.springema.model.Employee;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    // inject employeeRepository by using annotation
	
	@Autowired    
	private EmployeeRepository employeeRepository;
	
	// build get all employees REST API
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}	
}
