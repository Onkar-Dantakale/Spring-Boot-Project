package com.mrc.employeeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrc.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	Optional<Employee> findByEmail(String email);
	
}
