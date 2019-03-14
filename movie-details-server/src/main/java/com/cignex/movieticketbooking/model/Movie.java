package com.cignex.movieticketbooking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;
	@NotEmpty
	private String movieName;
	@NotEmpty
	private String movieCategory;
	@NotEmpty
	@Size(min = 50, message = "Description should be minimum 50 characters")
	private String movieDescription;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent(message = "Date should be present or future")
	private Date movieReleaseDate;
	@Size(min = 1, message = "artist not be empty")
	private String[] movieActors;
	@NotEmpty
	private String movieDirector;
	@NotNull
	private double movieLength;
	private String posterPath;

}
