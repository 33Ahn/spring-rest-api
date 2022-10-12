package com.present.springema.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.present.springema.repository.EmployeeRepository;
import com.present.springema.exception.ResourceNotFoundException;
import com.present.springema.model.Employee;

// import java.util.HashMap;
import java.util.List;
// import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    // inject employeeRepository by using annotation
	
	@Autowired    
	private EmployeeRepository employeeRepository;
	
	// build get all employees REST API
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}	
	
	// build get employee by id REST API;
	
	@GetMapping("{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> employee = employeeRepository.findById(id);	
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee does not exist");		
		}			
	}
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//		
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: " + id));
//		return ResponseEntity.ok(employee);
	
	// build add employee REST API
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);		
	}	
	
	// build update employee REST API
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employeeInfo) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
		
		employee.setFirstName(employeeInfo.getFirstName());
		employee.setLastName(employeeInfo.getLastName());
		employee.setEmail(employeeInfo.getEmail());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);	
	}
	
	// build delete employee REST API
	
	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
		
		employeeRepository.deleteById(id);			
	}
	
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
			
}
	
	












