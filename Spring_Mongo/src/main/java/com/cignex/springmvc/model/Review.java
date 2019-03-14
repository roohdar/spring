package com.cignex.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {
	private String userName;
	private int rating;
	private Boolean approved;
	public Review() {
	}
	
	

}
