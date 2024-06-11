package com.example.app.controller;

import java.util.List;

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

import com.example.app.model.Employee;
import com.example.app.service.EmployeeService;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping("/SaveEmployee")
	public ResponseEntity<?>saveEmployee(@RequestBody Employee employee){
		Employee saveData=employeeService.saveEmployee(employee);
		if (saveData != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(saveData);
			
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to Save Data");
		}
		
	}
	
	@GetMapping("/GetList")
	public ResponseEntity<List<Employee>>getAllEmployee(){
		List<Employee>getData=employeeService.getAllEmployee();
		return ResponseEntity.ok(getData);
	}
	
	@GetMapping("/GetListById/{id}")
	public ResponseEntity<?>getEmployeeById(@PathVariable Long id){
		
		Employee findDataById=employeeService.getEmployeeById(id);
		if (findDataById != null) {
			
			return ResponseEntity.status(HttpStatus.OK).body(findDataById);
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
		
	}
	
	@DeleteMapping("DeleteEmployee/{id}")
	public ResponseEntity<?>deleteEmployee(@PathVariable long id){
		Employee findData=employeeService.deleteEmployee(id);
		if (findData != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Data Deleted Successfully");
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
		
	}
	
	@PutMapping("/UpdateEmployee/{id}")
	public ResponseEntity<?>updateEmp(@PathVariable Long id, @RequestBody Employee updateEmployee){
		Employee findData=employeeService.updateEmp(id, updateEmployee);
		if (findData != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Data Update SuccessFully");
			
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
	}
	
	

}












