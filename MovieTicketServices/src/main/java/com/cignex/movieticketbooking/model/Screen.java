package com.cignex.movieticketbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screen {

	@Id
	@GeneratedValue
	private Integer screenNumber;
	private String[] platinumSeats;
	private String[] goldSeats;
	private String[] silverSeats;
	
}
