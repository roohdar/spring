package com.cignex.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.springboot.exceptionahandler.Myexception;
import com.cignex.springboot.service.EmployeeService;

@RestController
@SpringBootApplication
public class SpringAopApplication {

	@Autowired
	EmployeeService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@GetMapping
	private void addemp(@RequestParam("name") String name) {
		if (name.isEmpty()) {
			throw new Myexception();
		}
		service.createEmployee(name);
	}

}
