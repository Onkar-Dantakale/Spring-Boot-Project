package com.example.app.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
	            ResourceNotFoundException exception, WebRequest webRequest) {
	        
	        ErrorDetails errorDetails = new ErrorDetails(
	                LocalDateTime.now(),
	                exception.getMessage(),
	                webRequest.getDescription(false), 
	                "USER_NOT_FOUND"
	        );
	        
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(EmailAlreadyException.class)
	    public ResponseEntity<ErrorDetails> EmailAlreadyException(
	    		EmailAlreadyException exception, WebRequest webRequest) {
	        
	        ErrorDetails errorDetails = new ErrorDetails(
	                LocalDateTime.now(),
	                exception.getMessage(),
	                webRequest.getDescription(false), 
	                "EMAIL_ALREADY_EXIST"
	        );
	        
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorDetails> handleGlobalException(
	    	Exception exception, WebRequest webRequest) {
	        
	        ErrorDetails errorDetails = new ErrorDetails(
	                LocalDateTime.now(),
	                exception.getMessage(),
	                webRequest.getDescription(false), 
	                "MISSING_SOMTHING_IN_URL"
	        );
	        
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
		/*
		 * @Override protected ResponseEntity<Object>
		 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
		 * headers, HttpStatusCode status, WebRequest request) {
		 * 
		 * 
		 * Map<String, String> errors = new HashMap<>();
		 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
		 * ((org.springframework.validation.FieldError) error).getField(); String
		 * errorMessage = error.getDefaultMessage(); errors.put(fieldName,
		 * errorMessage); });
		 * 
		 * return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); }
		 */
		 
	}
	 


