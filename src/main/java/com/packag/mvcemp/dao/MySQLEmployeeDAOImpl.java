package com.packag.mvcemp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packag.mvcemp.model.Employee;

@Repository(value = "mysqlDaoImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int insert(Employee employee) {
		String query = "insert into employee values('" + employee.getId() + "','" + employee.getName() + "','"
				+ employee.getAge() + "','" + employee.getSalary() + "')";
		System.out.println("Insert Employee in MySQL DAO");
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.update(query);

	}

	public void update(int id,int salary) {
		// TODO Auto-generated method stub
		String query ="update employee set salary=? where id=?";
		System.out.println("Update Employee in MySQL DAO");
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(query,salary,id);	
	}

	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		List<Employee> empList=jdbcTemplate.query("select * from employee",
				(rs,rowNum) -> new Employee(rs.getInt(1),rs.getString(2),rs.getInt(1),rs.getDouble(4)));
		return empList;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String query=" delete from employee where id=?";
		System.out.println("Delete Employee in MySQL DAO");
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(query,id);
		
	}

	@Override
	public Employee retreive(int id) {
		
		String query="select * from employee where id="+id;
		//List<Employee> empList=jdbcTemplate.query(query,
		//		(rs,rowNum) -> new Employee(rs.getInt(1),rs.getString(2),rs.getInt(1),rs.getDouble(4)));
		//return empList.get(0);
		
		return jdbcTemplate.queryForObject(query,
				(rs,rowNum) -> new Employee(rs.getInt(1),rs.getString(2),rs.getInt(1),rs.getDouble(4)));
		// TODO Auto-generated method stub
		
	}

}
