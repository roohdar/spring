package com.cignex.springboot.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cignex.springboot.exceptionhandler.Myexception;
import com.cignex.springboot.model.Student;
import com.cignex.springboot.repository.StudentRepository;

@Service
public class StudentServices {

	@Autowired
	StudentRepository repository;

	public Student addUpdateStudent(Student student) {
		return repository.save(student);
	}

	public String deleteStudent(int id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new Myexception(e.getMessage(), e);
		}
		return "deleted Student";
	}

	public Student getStudent(int id) {
		Student student = null;
		try {
			student = repository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new Myexception(e.getMessage(), e);
		}
		return student;
	}

	public List<Student> getAllStudent() {
		return repository.findAll();
	}

	public List<Student> getAllStudentByCity(String city) {
		return repository.getByCity(city);
	}

}
