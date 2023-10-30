package com.mk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mk.dto.EmployeeDTO;
import com.mk.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("api/employees")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employee) {

		EmployeeDTO saveEmployee = service.saveEmployee(employee);

		ResponseEntity<EmployeeDTO> response = new ResponseEntity<>(saveEmployee, HttpStatusCode.valueOf(201));

		return response;

	}
	
	@GetMapping("api/employee/{EmpId}")
	EmployeeDTO getEmployee(@PathVariable("EmpId") Long id) {

		EmployeeDTO emplyee = service.getEmplyee(id);
		return emplyee;

	}
	
	@GetMapping("api/employee")
	List<EmployeeDTO > findAllEmployee(){
		
		List<EmployeeDTO> empListDto= service.getAllEmployee();
		
		
		return empListDto;
		
	}

	@GetMapping("api/employees")
	List<EmployeeDTO> findAllEmp(@RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy") String sortBy) {

		List<EmployeeDTO> empListDto = service.getAllEmployeeWithPaging(pageSize, pageNo, sortBy);

		return empListDto;

	}
}
	
	

