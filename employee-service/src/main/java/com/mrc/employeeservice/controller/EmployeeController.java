package com.mrc.employeeservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mrc.employeeservice.dto.EmployeeDto;
import com.mrc.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/Employees-Service")
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	
	@PostMapping("/Save_Employee")
	public ResponseEntity<?> saveEmployee( @RequestBody  EmployeeDto employeeDto){
		
		EmployeeDto saveData =employeeService.saveEmployee(employeeDto);
		if (saveData != null) {
			Map<String, Object> saveMap = new HashMap<>();
			saveMap.put("Message", "Data Saved Successfully");
			saveMap.put("Data", saveData);
			return ResponseEntity.status(HttpStatus.CREATED).body(saveMap);
			
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed To Saved Data");

		}
		
	}
	
	@GetMapping("/GetListOfEmployees")
	public ResponseEntity<List<EmployeeDto>>getAllEmployeeList(){
		List<EmployeeDto> getAllData = employeeService.getAllEmployeeList();
		return ResponseEntity.ok(getAllData);
		
	}
	
	@GetMapping("/GetEmployeeById/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
		
		EmployeeDto getEmployeeById=employeeService.getEmployeeById(id);
		if (getEmployeeById != null) {
			
			return ResponseEntity.status(HttpStatus.OK).body(getEmployeeById);
			
		} else {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

		}
		
		
	}
	
	@DeleteMapping("/DeleteEmployeeById/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long id){
		
		EmployeeDto deleteData =employeeService.deleteEmployee(id);
		if (deleteData != null) {
			
			return ResponseEntity.status(HttpStatus.OK).body("Data Deleted Successfully");
			
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
		
	}
	
	
	@PutMapping("/UpdateEmployeeById/{id}")
	public ResponseEntity<?>updateEmployeeById(@PathVariable long id, @RequestBody EmployeeDto updateEmployee){
		
		EmployeeDto updateData =employeeService.updateEmployeeById(id, updateEmployee);
		if (updateData != null) {
			
			Map<String, Object> saveMap = new HashMap<>();
			saveMap.put("Message", "Data Updated Successfully");
			saveMap.put("UPDATED_DATA", updateData);
			return ResponseEntity.ok(saveMap);
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
		
		
	}
	

}
