package com.mk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mk.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
}
