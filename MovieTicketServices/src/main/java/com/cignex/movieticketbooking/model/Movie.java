package com.cignex.movieticketbooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long movieId;
	private String movieName;	
	private String movieCategory;
	private String movieDescryption;
	private Date movieReleaseDate;
	private String[] movieActors;
	private String movieDirector;
	private double movieLength;	
	@Transient
	private byte[] moviePoster;
	private String posterPath;

}
