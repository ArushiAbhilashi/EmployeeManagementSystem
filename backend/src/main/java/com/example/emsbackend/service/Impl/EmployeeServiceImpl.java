package com.example.emsbackend.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.exception.ResourceNotFoundException;
import com.example.emsbackend.mapper.EmployeeMapper;
import com.example.emsbackend.repository.EmployeeRepository;
import com.example.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	public  EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployeeDetails(Long employeeId,EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
				new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedEmployeeDto=employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeDto);
	}
	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
				new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));
		employeeRepository.deleteById(employeeId);
		
		
	}

}
