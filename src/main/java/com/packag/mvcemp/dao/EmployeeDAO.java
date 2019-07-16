package com.packag.mvcemp.dao;

import java.util.List;

import com.packag.mvcemp.model.Employee;

public interface EmployeeDAO {

	public int insert(Employee employee);

	public void update(int id,int salary);

	public List<Employee> listAll();

	public void delete(int id);

	public Employee retreive(int id);
	
}
