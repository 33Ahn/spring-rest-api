package com.present.springema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.present.springema.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
