package com.example.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private long feildvalue;
	public ResourceNotFoundException(String resourceName, String fieldName, long feildvalue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName,feildvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.feildvalue = feildvalue;
	}
	
	
		

}
