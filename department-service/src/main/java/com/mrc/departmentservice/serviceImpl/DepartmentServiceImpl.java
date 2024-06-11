package com.mrc.departmentservice.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrc.departmentservice.dto.DepartmentDto;
import com.mrc.departmentservice.exception.DepartmentNotFoundException;
import com.mrc.departmentservice.exception.ResourceNotFoundException;
import com.mrc.departmentservice.model.Department;
import com.mrc.departmentservice.repository.DepartmentRepository;
import com.mrc.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	public DepartmentRepository departmentRepository;

	@Autowired
	public ModelMapper modelMapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		Department department = modelMapper.map(departmentDto, Department.class);

		Department saveDepartment = departmentRepository.save(department);

		return modelMapper.map(saveDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {

		Department getDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));

		return modelMapper.map(getDepartment, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getListOfDepartments() {

		List<Department> findAllList = departmentRepository.findAll();
		return findAllList.stream().map(department -> modelMapper.map(department, DepartmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department findByCode = departmentRepository.findByDepartmentCode(departmentCode);
		if (findByCode == null) {
			
			throw new DepartmentNotFoundException("Department", "code", departmentCode);
			
		}
		
		 return modelMapper.map(findByCode, DepartmentDto.class);		 
		
		
	}
}
