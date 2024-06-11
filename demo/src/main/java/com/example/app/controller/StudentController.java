package com.example.app.controller;

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

import com.example.app.dto.StudentResponse;
import com.example.app.service.StudentService;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
		name= "CRUD REST APIs for Student Resource",
		description= "CRUD APIs - Create Student Info,"
				+ "Update Student Info,"
				+ "Get List Of Student,"
				+ "Get Student List By thier Id's"
				+ "Delete Student Info"
				
		
		
		)

@RestController
@RequestMapping("/Demo")
public class StudentController {

	@Autowired
	public StudentService studentService;

	
	
	@PostMapping("/Save")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentResponse studentResponse) {
		StudentResponse saveData = studentService.saveStudent(studentResponse);
		if (saveData != null) {
			Map<String, Object> saveMap=new HashMap<>();
			saveMap.put("Message", "Data Saved Successfully");
			saveMap.put("Data", saveData);
			return ResponseEntity.status(HttpStatus.OK).body(saveMap);

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Save");

		}
	}

	
	
			
	
	@GetMapping("/Get/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id) {
		StudentResponse findStudent = studentService.getStudentById(id);

		if (findStudent != null) {
			
		
			return ResponseEntity.status(HttpStatus.OK).body(findStudent);

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}

	}

	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		StudentResponse deleteData = studentService.delete(id);

		if (deleteData != null) {

			return ResponseEntity.status(HttpStatus.OK).body("Data Deleted Successfully");

		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Body");
		}
	}

	@GetMapping("/GetAllList")
	public ResponseEntity<List<StudentResponse>> getAll() {
		List<StudentResponse> getAllData = studentService.getAll();
		return ResponseEntity.ok(getAllData);
	}
	
	@PutMapping("/Update/{id}")
	public ResponseEntity<?>updateStudent(@PathVariable Long id, @RequestBody @Valid StudentResponse updateStudentResponse){
		StudentResponse updateData=studentService.updateStudent(id, updateStudentResponse);
		if (updateData!=null) {
			 
			 Map<String, Object> responseMap = new HashMap<>();
		        responseMap.put("message", "Data Update Successfully");
		        responseMap.put("data", updateData);
		        
		        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
			
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
	}
	
	/*
	 * @ExceptionHandler(ResourceNotFoundException.class) public
	 * ResponseEntity<ErrorDetails>handleResourceNotFoundException(
	 * ResourceNotFoundException exception, WebRequest webRequest, ErrorCodes
	 * errorCodes){
	 * 
	 * ErrorDetails errorDetails= new ErrorDetails( LocalDateTime.now(),
	 * exception.getMessage(), webRequest.getDescription(false),
	 * ErrorCodes.USER_NOT_FOUND.getCode() // Accessing the error code directly from
	 * ErrorCodes 
	 * 
	 * ); return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */




	
}
		
	


