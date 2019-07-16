package com.packag.mvcemp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packag.mvcemp.dao.EmployeeDAO;
import com.packag.mvcemp.model.Employee;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void insertEmployee(Employee employee) {
		System.out.println("Insert Employee in Employee Service");
		employeeDAO.insert(employee);
	}

	public void updateEmployee(int id,int salary) {
		System.out.println("Update Employee in Employee Service");
		employeeDAO.update(id,salary);
		
	}

	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return employeeDAO.listAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeDAO.delete(id);
	}

	@Override
	public Employee retreiveById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.retreive(id);
		
	}
	
	

}
