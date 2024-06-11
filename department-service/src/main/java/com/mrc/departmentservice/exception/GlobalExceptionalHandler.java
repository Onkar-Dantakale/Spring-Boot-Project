package com.mrc.departmentservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionalHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
			   
			ResourceNotFoundException exception, WebRequest webRequest){
		   
		ErrorDetails errorDetails = new ErrorDetails(
				
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"DEPARTMENT_NOT_FOUND"
				);
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleDepartmentNotFoundException(
			
			DepartmentNotFoundException exception, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"DEPARTMENT_NOT_FOUND_OF_THIS_CODE"
				
				
				);
		
		return new ResponseEntity<>	(errorDetails,HttpStatus.NOT_FOUND);
		
	
	}
	

			
	
	
	
	
	

}
