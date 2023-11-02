package com.mk.department.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.department.dto.DepartmentDTO;
import com.mk.department.entity.Department;
import com.mk.department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO dto) {

		Department departmentEntity = departmentRepository.save(mapper.map(dto, Department.class));

		DepartmentDTO departmentDto = mapper.map(departmentEntity, DepartmentDTO.class);

		return departmentDto;
	}

	@Override
	public DepartmentDTO getDepartmentById(Long id) {
		
		Department department = departmentRepository.getById(id);
		
		DepartmentDTO dto = mapper.map(department, DepartmentDTO.class);
		
		return dto;
	}

}
