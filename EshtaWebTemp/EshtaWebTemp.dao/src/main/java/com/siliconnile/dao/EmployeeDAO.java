package com.siliconnile.dao;

import java.util.List;

import com.siliconnile.domain.Employee;




public interface EmployeeDAO {
	
		  void persistEmployee(Employee employee);
		  
		  Employee findEmployeeById(long id);
		  
		  void updateEmployee(Employee employee);
		  
		  void deleteEmployee(Employee employee);
		  public List<Employee> getEmployees();
}