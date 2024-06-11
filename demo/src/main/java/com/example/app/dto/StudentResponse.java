package com.example.app.dto;

import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentResponse {


	private long id;
	
	@NotEmpty(message = "Student Name Must not Be Empty or Null")  	//Student name should not be null or empty
	private String name;
	
	@NotEmpty(message = "Student Email Must not Be Empty or Null")  //Student name should not be null or empty
	@Email     //Email Address Should be valid
    private String email;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    
    
}
