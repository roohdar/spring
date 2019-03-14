package com.cignex.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String[] courses;
	private Date bday;
	private String city;

}
