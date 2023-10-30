package com.mk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mk.dto.EmployeeDTO;

@Service
public interface EmployeeService {
	
	EmployeeDTO saveEmployee(EmployeeDTO employee);
	
	EmployeeDTO getEmplyee(Long id);
	
	List<EmployeeDTO> getAllEmployee();
	
	List<EmployeeDTO> getAllEmployeeWithPaging(Integer pageSize, Integer pageNo,String sortBy );

}
