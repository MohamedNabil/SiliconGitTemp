package com.siliconnile.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.ui.Model;

import com.siliconnile.domain.Employee;
import com.siliconnile.service.api.EmployeeService;


import java.util.Map;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	

	@RequestMapping(value="/employee/add")
	public String addEmployeePage() {

		Employee employee = new Employee();
		
		return "Add new Employee";
	}
	
	@RequestMapping(value="/employee/add/process")
	public  String addingEmployee(final Model model,@ModelAttribute Employee employee) {
		
		
		employeeService.persistEmployee(employee);
		
		String message = "Employee was successfully added.";
	
		model.addAttribute("message", message);
		return "Home";
	}
	
	@RequestMapping(value="/employee/list")
	public String listOfEmployees(final Model model,Map<String, Object> map) {
		
		List<Employee> employees = employeeService.listEmployees();
	
		model.addAttribute("Employees",employees);
	
		return "Home";
	}
	
	@RequestMapping(value="/employee/edit/{id}", method=RequestMethod.GET)
	public String editEmployeePage(@PathVariable Integer id) {
		
		Employee employee = employeeService.findEmployeeById(id);
		
		return "Edit employee";
	}
	
	@RequestMapping(value="/employee/edit/{id}", method=RequestMethod.POST)
	public String edditingEmployee(final Model model,@ModelAttribute Employee employee, @PathVariable Integer id) {
		
		
		employeeService.updateEmployee(employee);
		
		String message = "Employee was successfully edited.";
		model.addAttribute("message", message);
		
		return "Home";
	}
	
	@RequestMapping(value="/employee/delete/{id}", method=RequestMethod.GET)
	public String deleteTeam(final Model model,@PathVariable Integer id,@ModelAttribute Employee employee) {
		
		
		employeeService.deleteEmployee(employee);
		String message = "Employee was successfully deleted.";
		model.addAttribute("message", message);
		return "Home";
		
	}

}