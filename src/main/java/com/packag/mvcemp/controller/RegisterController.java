package com.packag.mvcemp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packag.mvcemp.model.Employee;
import com.packag.mvcemp.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class RegisterController {
	
	
 @GetMapping("/login")
 public String login()
 {
	 return "login";
 }
 
 @GetMapping("/register")
 public String register()
 {
	 return "register";
 }


 @GetMapping("/display")
 public String displayAll(Model model)
 {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
		
		Employee cooper = new Employee(110,"Keshu", 21, 50000);
		employeeService.insertEmployee(cooper);
		employeeService.updateEmployee(108, 10000);
		employeeService.delete(105);
		List<Employee> empList= employeeService.listAll();
		model.addAttribute("emplist", empList);
		//Consumer<Employee> c= (employee) -> System.out.println(employee);
		//empList.forEach(c);
		//Employee emp=employeeService.retreiveById(110);
		//System.out.println(emp);
		return "display";
 }
 

}
