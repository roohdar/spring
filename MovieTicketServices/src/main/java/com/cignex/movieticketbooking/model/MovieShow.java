package com.cignex.movieticketbooking.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="moviesshow")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieShow {

	@Id
	@GeneratedValue
	private Integer showId;
	private Date showDate;
	private Time showTime;
	private String[] bookedseats;
	private int platinumPrice;
	private int goldPrice;
	private int silverPrice;	
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private Screen screen;		
}
