package com.mrc.employeeservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeIdNotFoundException(
			EmployeeIdNotFoundException exception, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"EMPLOYEE_NOT_FOUND"
				);
		
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(
			
			EmailAlreadyExistException exception, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"EMAIL_ALREADY_EXIST_PLEASE_PUT_VALID_EMAIL ADREESS"
				);
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handleGlobalException(
			Exception exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"SOMETHING_IS_MISSING_IN_URL"
				);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_GATEWAY);
		
	}
	

}
