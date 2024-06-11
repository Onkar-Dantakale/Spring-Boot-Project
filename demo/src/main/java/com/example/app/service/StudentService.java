package com.example.app.service;

import java.util.List;

import com.example.app.dto.StudentResponse;

public interface StudentService {
	
	public StudentResponse saveStudent(StudentResponse studentResponse);
	
	public List<StudentResponse>getAll();

	public StudentResponse getStudentById(Long id);
	
	public StudentResponse delete(Long id);
	
	public StudentResponse updateStudent(Long id, StudentResponse updateStudentResponse);
	
	
	
	
}
