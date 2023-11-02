package com.mk.department.service;

import org.springframework.stereotype.Service;

import com.mk.department.dto.DepartmentDTO;

@Service
public interface DepartmentService {
	
	public DepartmentDTO saveDepartment(DepartmentDTO dto);

	public DepartmentDTO getDepartmentById(Long id);

}
