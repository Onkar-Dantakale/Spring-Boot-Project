package com.mrc.employeeservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrc.employeeservice.dto.EmployeeDto;
import com.mrc.employeeservice.exception.EmailAlreadyExistException;
import com.mrc.employeeservice.exception.EmployeeIdNotFoundException;
import com.mrc.employeeservice.model.Employee;
import com.mrc.employeeservice.repository.EmployeeRepository;
import com.mrc.employeeservice.service.APIClient;
import com.mrc.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Optional<Employee> saveEmployeeData=employeeRepository.findByEmail(employeeDto.getEmail());
		if(saveEmployeeData.isPresent()) {
			throw new EmailAlreadyExistException("EMAIL_ALREADY_EXIST");
		}
		Employee saveEmployee = employeeRepository.save(employee);
		return modelMapper.map(saveEmployee, EmployeeDto.class);
		
	}

	@Override
	public List<EmployeeDto> getAllEmployeeList() {
			List<Employee>findListOfEmployee=employeeRepository.findAll();
			return findListOfEmployee.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
					.collect(Collectors.toList());
		
	
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
	
	    Employee getEmployee = employeeRepository.findById(id).orElseThrow(
				()-> new EmployeeIdNotFoundException("Employee", "Id", id));
		return modelMapper.map(getEmployee, EmployeeDto.class);
		
	}

	@Override
	public EmployeeDto deleteEmployee(long id) {
		
		Employee deleteEmployee = employeeRepository.findById(id).orElseThrow(
				()-> new EmployeeIdNotFoundException("Employee", "ID", id));
		return modelMapper.map(deleteEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployeeById(long id, EmployeeDto updateEmployee) {
	
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		if (findEmployee.isPresent()) {
			Employee employeeExist = findEmployee.get();
			employeeExist.setFirstName(updateEmployee.getFirstName());
			employeeExist.setLastName(updateEmployee.getLastName());
			employeeExist.setEmail(updateEmployee.getEmail());
			employeeExist.setId(updateEmployee.getId());
			 
			return modelMapper.map(employeeExist, EmployeeDto.class);
			
		} else {
		      throw new EmployeeIdNotFoundException("Employee", "Id", id);

		}
		
		
	}

}
