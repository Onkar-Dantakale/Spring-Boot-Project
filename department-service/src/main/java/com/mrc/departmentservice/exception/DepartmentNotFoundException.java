package com.mrc.departmentservice.exception;

public class DepartmentNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private static String fieldName;
	private String fieldValue;
	
	public DepartmentNotFoundException(String resourceName, String filedName, String fieldValue) {
		super(String.format("%s is not found with %s : %s", resourceName, fieldName, fieldValue));
		this.fieldName=filedName;
		this.fieldValue=fieldValue;
		this.resourceName=resourceName;
		
	}
}
