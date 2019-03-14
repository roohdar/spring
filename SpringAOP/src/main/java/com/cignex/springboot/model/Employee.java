package com.cignex.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

	private String name;

	public void throeException() {
		throw new RuntimeException("Dummy Exception");
	}

}
