package com.mrc.employeeservice.service;

import java.util.List;

import com.mrc.employeeservice.dto.EmployeeDto;


public interface EmployeeService {

	public EmployeeDto saveEmployee (EmployeeDto employeeDto);
	
	public List<EmployeeDto> getAllEmployeeList();
	
	public EmployeeDto getEmployeeById (long id);
	
	public EmployeeDto deleteEmployee(long id);
	
	public EmployeeDto updateEmployeeById(long id, EmployeeDto updateEmployee);
	
	
	
}
