package com.packag.mvcemp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packag.mvcemp.model.Employee;
import com.packag.mvcemp.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class RegisterController {
	
	@Autowired
	private EmployeeService employeeService;
 @GetMapping("/login")
 public String login()
 {
	 return "login";
 }
 
 


 @GetMapping("/display")
 public String displayAll(Model model)
 {
		
		
		Employee cooper = new Employee(113,"Keshu", 21, 50000);
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
 
 @GetMapping("/{id}")
 public String displayEmp(@PathVariable("id") int id,Model model)
 {
	
		Employee employee=employeeService.retreiveById(id);
		
		model.addAttribute("emp", employee);
	 return "getid" ;
 }
 
 @GetMapping("/register")
 public String registerForm(Model model)
 {
	 model.addAttribute("employee", new Employee());
	 return "register";
 }
 
 @PostMapping("/register")
 public String registerEMployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result )
 {
	 System.out.println(employee);

	 System.out.println("Registered successfully");
	 if (result.hasErrors()) {
         return "register";
      }
	 employeeService.insertEmployee(employee);
	 return "success";
 }
}
