package com.mk.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mk.dto.EmployeeDTO;
import com.mk.entity.Employee;
import com.mk.exception.ResourceNotFoundException;
import com.mk.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

		// Employee savedemployee =
		// employeeRepository.save(EmployeeMapper.dtoToEntity(employeeDTO));

		Employee savedemployee = mapper.map(employeeDTO, Employee.class);
		
		Employee employeeEntity = employeeRepository.save(savedemployee);

		EmployeeDTO employeeDTORetuned = mapper.map(employeeEntity, EmployeeDTO.class);

		return employeeDTORetuned;
	}

	@Override
	public EmployeeDTO getEmplyee(Long id) {
		try {
			Employee emp = null;

			Optional<Employee> employee = employeeRepository.findById(id);

			if (employee.isPresent()) {

				emp = employee.get();
			}

			// convert Employee entity to dto
				
//			EmployeeDTO entityToDto = EmployeeMapper.entityToDto(emp);
			
			EmployeeDTO entityToDto = mapper.map(employee, EmployeeDTO.class);

			return entityToDto;
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage(),id);
		}
	}
	
	
	
	
	

}
