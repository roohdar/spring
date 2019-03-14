package com.cignex.soapservices.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.cignex.soapmodel.Employee;

@Service
public class EmployeeService {

	private List<Employee> employees = new ArrayList<>();

	@PostConstruct
	public void initialise() {

		employees.add(new Employee(1, "Rahul", "Patidar", "developer", "rahul@gmail.com"));
		employees.add(new Employee(2, "pinal", "serdiya", "developer", "pinal@gmail.com"));
	}

	public Employee getemp(int id) {
		for (Employee emp : employees) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}

}
