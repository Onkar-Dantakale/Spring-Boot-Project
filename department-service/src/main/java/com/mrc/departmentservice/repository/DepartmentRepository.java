package com.mrc.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrc.departmentservice.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDepartmentCode(String departmentCode);
	
}
