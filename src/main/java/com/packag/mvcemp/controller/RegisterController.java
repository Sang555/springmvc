package com.packag.mvcemp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class RegisterController {
	
 @GetMapping("/login")
 public String login()
 {
	 return "login";
 }

}
