package com.packag.mvcemp.service;

import java.util.List;

import com.packag.mvcemp.model.Employee;

public interface EmployeeService {

	public void insertEmployee(Employee employee);
	public void updateEmployee(int id,int salary);
	public List<Employee> listAll();
	public void delete(int id);
	public Employee retreiveById(int id);
}
