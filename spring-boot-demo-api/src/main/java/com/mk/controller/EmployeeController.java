package com.mk.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.mk.dto.EmployeeDTO;
import com.mk.exception.ErrorDetails;
import com.mk.exception.ResourceNotFoundException;
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
	
}
