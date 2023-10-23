package com.mk.mapper;

import com.mk.dto.EmployeeDTO;
import com.mk.entity.Employee;

public class EmployeeMapper {

	// dto to entity

	public static Employee dtoToEntity(EmployeeDTO employeeDTO) {

		Employee empEntity = new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(),
				employeeDTO.getEmail(), employeeDTO.getDepartmentCode(), employeeDTO.getOrganizationCode());

		return empEntity;

	}

	// entity to dto

	public static EmployeeDTO entityToDto(Employee employeeEntity) {

		EmployeeDTO empDto = new EmployeeDTO(employeeEntity.getId(), employeeEntity.getFirstName(),
				employeeEntity.getLastName(), employeeEntity.getEmail(), employeeEntity.getDepartmentCode(),
				employeeEntity.getOrganizationCode());

		return empDto;

	}

}
