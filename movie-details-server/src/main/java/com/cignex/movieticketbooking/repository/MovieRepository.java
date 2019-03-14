package com.cignex.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cignex.movieticketbooking.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	public Movie findByMovieName(String movieName);

}
