package com.example.app.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.StudentResponse;
import com.example.app.exception.EmailAlreadyException;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.model.Student;
import com.example.app.repository.StudentRepository;
import com.example.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	public StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;


	

	@Override
	public StudentResponse saveStudent(StudentResponse studentResponse) {

		Student student = modelMapper.map(studentResponse, Student.class); // Convert StudentResponse to Student
		Optional<Student>findStuByEmial=studentRepository.findByEmail(studentResponse.getEmail());
		if(findStuByEmial.isPresent()) {
			throw new EmailAlreadyException("Email Alreday Exist for a Student");
		}
		Student savedStudent = studentRepository.save(student); // Save the Student object
		return modelMapper.map(savedStudent, StudentResponse.class); // Convert saved Student back to StudentResponse
	}
	
	
	@Override
	public StudentResponse getStudentById(Long id) {

		Student getStudent = studentRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student", "id", id));
		
			return modelMapper.map(getStudent, StudentResponse.class);


		}
		
		/*
		 * if (getStudent.isPresent()) {
		 * 
		 * Student studentExist = getStudent.get(); return modelMapper.map(studentExist,
		 * StudentResponse.class);
		 * 
		 * } else { return null;
		 * 
		 */


	@Override
	public StudentResponse delete(Long id) {
		
		Student getSudent= studentRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student", "id", id));
		
		return modelMapper.map(getSudent, StudentResponse.class);
		
		
		
		/*
		 * Optional<Student> findStudent = studentRepository.findById(id); if
		 * (findStudent.isPresent()) {
		 * 
		 * Student studentExist = findStudent.get(); studentRepository.deleteById(id);
		 * return modelMapper.map(studentExist, StudentResponse.class);
		 * 
		 * } else { return null;
		 * 
		 * }
		 */

	}

	@Override
	public List<StudentResponse> getAll() {
		List<Student> findAllList = studentRepository.findAll();
		return findAllList.stream().map(student -> modelMapper.map(student, StudentResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public StudentResponse updateStudent(Long id, StudentResponse updateStudentResponse) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			
			Student existingStudent = optionalStudent.get();

			existingStudent.setName(updateStudentResponse.getName());
			existingStudent.setEmail(updateStudentResponse.getEmail());
		     studentRepository.save(existingStudent);
			return modelMapper.map(existingStudent, StudentResponse.class);
		} else {
			return null;
		}
	}

}
