package com.cignex.springboot.service;

import org.springframework.stereotype.Service;

import com.cignex.springboot.exceptionahandler.Myexception;
import com.cignex.springboot.model.Employee;

@Service
public class EmployeeService {

	public String createEmployee(String name) {
		if (name == null) {
			throw new Myexception();
		}
		Employee employee = new Employee();
		employee.setName(name);

		return employee.toString();
	}

}
