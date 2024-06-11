package com.example.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Employee;
import com.example.app.repository.EmployeeRepository;
import com.example.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		if (findEmployee.isPresent()) {
			return findEmployee.get();

		} else {
			return null;

		}

	}

	@Override
	public Employee deleteEmployee(Long id) {
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		if (findEmployee.isPresent()) {

			Employee employeeExist = findEmployee.get();
			employeeRepository.deleteById(id);
			return employeeExist;

		} else {

			return null;

		}

	}

	@Override
	public Employee updateEmp(Long id, Employee updateEmployee) {
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		if (findEmployee.isPresent()) {
			Employee employeeExist = findEmployee.get();
			employeeExist.setId(updateEmployee.getId());
			employeeExist.setName(updateEmployee.getName());
			employeeExist.setEmail(updateEmployee.getEmail());
			employeeExist.setDepartment(updateEmployee.getDepartment());
			return employeeRepository.save(employeeExist);

		} else {
			return null;

		}

	}

}
