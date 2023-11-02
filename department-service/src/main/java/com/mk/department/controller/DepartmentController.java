package com.mk.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.department.dto.DepartmentDTO;
import com.mk.department.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("api/department")
	ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDto) {

		DepartmentDTO dto = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<DepartmentDTO>(dto, HttpStatus.CREATED);

	}
	
	
	@GetMapping("api/department/{id}")
	DepartmentDTO getDepartmentById(@PathVariable("id") Long id) {

		DepartmentDTO dto = departmentService.getDepartmentById(id);

		return dto;

	}
}
