package com.cignex.movieticketbooking.model;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Movie implements Serializable {
	private static final long serialVersionUID = -1678948262946367299L;
	private Long movieId;
	@NotNull
	private String movieName;
	@NotNull
	private String movieCategory;
	@NotNull
	private String movieDescryption;
	@NotNull
	private Date movieReleaseDate;
	@NotNull
	@Size(max = 5, min = 2)
	private String[] movieActors;
	@NotNull
	private String movieDirector;
	@NotNull
	private double movieLength;
	private byte[] moviePoster;
	private String posterPath;
}
