package com.cignex.springboot.restservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.springboot.model.Student;
import com.cignex.springboot.service.StudentServices;

@CrossOrigin /* (origins = "http://localhost:4200", maxAge = 3600) */
@RestController
@RequestMapping("/student")
public class StudentRestServices {

	@Autowired
	StudentServices service;

	@PostMapping("/add")
	private Student addStudent(@RequestBody Student student) {
		return service.addUpdateStudent(student);

	}

	@PostMapping("/update")
	private Student updateStudent(@RequestBody Student student) {
		// if (service.getStudent(student.getId()) == null)

		return service.addUpdateStudent(student);

	}

	@GetMapping("/get/{id}")
	private Student getById(@PathVariable("id") int id) {
		return service.getStudent(id);

	}

	@DeleteMapping("/delete/{id}")
	private String deleteById(@PathVariable("id") int id) {
		return service.deleteStudent(id);
	}

	@GetMapping("/get")
	private List<Student> getAll() {
		return service.getAllStudent();
	}
}
