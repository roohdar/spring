package com.cignex.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cignex.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("select s from Student s where s.city= : city")
	public List<Student> getByCity(String city);

}
