package com.siliconnile.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.siliconnile.dao.EmployeeDAO;
import com.siliconnile.domain.Employee;
import com.siliconnile.service.api.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void persistEmployee(Employee employee) {
		employeeDAO.persistEmployee(employee);
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}
	
	@Override
	@Transactional
	public Employee findEmployeeById(long id) {
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		employeeDAO.deleteEmployee(employee);
		
	}
	
	public List<Employee> listEmployees()
	{
		return employeeDAO.getEmployees();
	}

}