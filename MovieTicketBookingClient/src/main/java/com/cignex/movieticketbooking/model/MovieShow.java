package com.cignex.movieticketbooking.model;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieShow {

	private Integer showId;
	private Date showDate;
	private Time showTime;
	private Movie movie;
	private Screen screen;	
	private int platinumPrice;
	private int goldPrice;
	private int silverPrice;	
	private String[] bookedseats;
}
