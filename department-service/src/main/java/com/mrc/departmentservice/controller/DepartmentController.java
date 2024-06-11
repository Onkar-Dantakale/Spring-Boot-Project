package com.mrc.departmentservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrc.departmentservice.dto.DepartmentDto;
import com.mrc.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/Department-Service")
public class DepartmentController {

	@Autowired
	public DepartmentService departmentService;

	@PostMapping("/Save")
	public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto saveData = departmentService.saveDepartment(departmentDto);
		if (saveData != null) {
			Map<String, Object> saveMap = new HashMap<>();
			saveMap.put("Message", "DATA SAVED SUCCESSFULLY");
			saveMap.put("Data", saveData);
			return ResponseEntity.status(HttpStatus.OK).body(saveMap);

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Save Data");

		}
	}
	
	
	@GetMapping("/GetDepartment/{id}")
	  public ResponseEntity<?> getDepartment(@PathVariable Long id){
	  DepartmentDto findDepartment = departmentService.getDepartmentById(id);
	  if(findDepartment != null) {
		  
		  return ResponseEntity.status(HttpStatus.FOUND).body(findDepartment);
	  }else {
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Id");
	  }
	  
	}
	
	
	@GetMapping("/GetListOfDepartments")
	public ResponseEntity<List<DepartmentDto>> getAll(){
		List<DepartmentDto> getAllData = departmentService.getListOfDepartments();
		return ResponseEntity.ok(getAllData);		
	}
	
	
	
	@GetMapping("/GetDepartmentByCode/{departmentCode}")
	public ResponseEntity<?> getDepartmentByCode(@PathVariable String departmentCode){
		
		DepartmentDto findDepartmentByCode = departmentService.getDepartmentByCode(departmentCode);
		
		if (findDepartmentByCode != null) {
			
			
			return ResponseEntity.status(HttpStatus.FOUND).body(findDepartmentByCode);
			
		} else {
			
			return ResponseEntity.ok(HttpStatus.NOT_FOUND );

		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
