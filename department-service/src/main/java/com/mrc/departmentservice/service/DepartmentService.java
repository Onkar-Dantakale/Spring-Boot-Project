package com.mrc.departmentservice.service;

import java.util.List;

import com.mrc.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	public DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	public DepartmentDto getDepartmentById(Long id);
	
	public List<DepartmentDto> getListOfDepartments();
	
	public DepartmentDto getDepartmentByCode(String departmentCode);
	
	
}
