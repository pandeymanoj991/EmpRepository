package com.mk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mk.dto.DepartmentDTO;
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
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		
		String url = "http://localhost:8888/api/department/1";
		
		DepartmentDTO  dto = restTemplate.getForObject(url, DepartmentDTO.class, employeeDTO.getId());
		
		System.out.println("from Department:  "+dto.getDepartmentCode());


	//===========================================================	
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

	@Override
	public List<EmployeeDTO> getAllEmployee() {

		List<EmployeeDTO> empDTOList = new ArrayList<>();

		// List empList =new ArrayList<>();

		List<Employee> empList = employeeRepository.findAll();

		// convert lint of employee entity to list of employee dto

		for (Employee emp : empList) {

			EmployeeDTO entityToDto = mapper.map(emp, EmployeeDTO.class);

			empDTOList.add(entityToDto);

		}

		return empDTOList;
	}

	@Override
	public List<EmployeeDTO> getAllEmployeeWithPaging(Integer pageSize, Integer pageNo, String sortBy) {

		List<EmployeeDTO> empDTOList = new ArrayList<>();
		List<Employee> employeeList = null;

		// Page<T> findAll(Pageable pageable);

		Sort sortByName = Sort.by(sortBy);

		Pageable pageable = PageRequest.of(pageNo, pageSize, sortByName);

		Page<Employee> EmployeePage = employeeRepository.findAll(pageable);

		if (EmployeePage.hasContent()) {
			employeeList = EmployeePage.getContent();
		}

		for (Employee emp : employeeList) {

			EmployeeDTO employeeToDto = mapper.map(emp, EmployeeDTO.class);

			empDTOList.add(employeeToDto);

		}

		return empDTOList;
	}

}
