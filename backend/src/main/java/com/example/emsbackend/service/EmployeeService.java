package com.example.emsbackend.service;

import java.util.List;

import com.example.emsbackend.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long employeeId);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployeeDetails(Long employeeId,EmployeeDto updatedEmployee);
	void deleteEmployee(Long employeeId);

}
