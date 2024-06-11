package com.mrc.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mrc.employeeservice.dto.DepartmentDto;


@FeignClient (name = "DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("/GetDepartmentByCode/{departmentCode}")
	DepartmentDto getDepartmentByCode(@PathVariable String departmentCode);
		
	
	
	
}
