package com.example.app.service;

import java.util.List;

import com.example.app.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(Long id);
	
	public Employee deleteEmployee(Long id);
	
	public Employee updateEmp(Long id, Employee updateEmployee);

}
