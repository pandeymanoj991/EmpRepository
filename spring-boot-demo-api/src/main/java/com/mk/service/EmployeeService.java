package com.mk.service;

import org.springframework.stereotype.Service;

import com.mk.dto.EmployeeDTO;

@Service
public interface EmployeeService {
	
	EmployeeDTO saveEmployee(EmployeeDTO employee);
	
	EmployeeDTO getEmplyee(Long id);

}
