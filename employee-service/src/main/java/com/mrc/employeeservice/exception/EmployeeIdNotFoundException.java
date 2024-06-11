package com.mrc.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeIdNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private long fieldValue;
	
	public EmployeeIdNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s is not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		
		
	}

}
