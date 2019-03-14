package com.cignex.movieticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Screen {

	private Integer screenNumber;
	private String[] platinumSeats;
	private String[] goldSeats;
	private String[] silverSeats;

}
