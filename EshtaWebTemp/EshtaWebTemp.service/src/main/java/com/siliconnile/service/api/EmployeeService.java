package com.siliconnile.service.api;

import java.util.List;

import com.siliconnile.domain.Employee;


public interface EmployeeService {

	void persistEmployee(Employee employee);

	Employee findEmployeeById(long id);

	void updateEmployee(Employee employee);

	void deleteEmployee(Employee employee);
	
	List<Employee> listEmployees();
}