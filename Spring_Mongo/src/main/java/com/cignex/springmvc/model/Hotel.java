package com.cignex.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="Hotels")
@Data
public class Hotel {

	@Id
	private String id;
	private String name;
	@Indexed(direction=IndexDirection.ASCENDING)
	private Integer pricePerNight;
	
	private Address address;
	private List<Review> reviews;

	protected Hotel() {
		this.reviews=new ArrayList<>();
	}

	public Hotel(String name, Integer pricePerNight, Address address, List<Review> reviews) {
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
	}



}
