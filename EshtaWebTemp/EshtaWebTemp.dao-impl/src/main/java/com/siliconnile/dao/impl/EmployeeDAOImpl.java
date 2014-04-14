package com.siliconnile.dao.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pearlox.framework.dao.impl.BasicJpaDao;
import com.siliconnile.dao.EmployeeDAO;
import com.siliconnile.domain.Employee;




@Repository("employeeDAO")
public class EmployeeDAOImpl  extends BasicJpaDao<Employee> implements EmployeeDAO {



	public EmployeeDAOImpl() {
		super(Employee.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee findEmployeeById(long id) {
		return (Employee) entityManager.find(Employee.class, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		entityManager.refresh(employee);

	}
	@Override
	public void deleteEmployee(Employee employee) {
		entityManager.remove(employee);

	}

	@Override
	public void persistEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		return getEntityManager().createQuery("from Employee").getResultList();
		
	}



}