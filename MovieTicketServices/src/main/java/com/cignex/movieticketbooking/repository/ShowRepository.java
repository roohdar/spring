package com.cignex.movieticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cignex.movieticketbooking.model.MovieShow;


@Repository
public interface ShowRepository extends JpaRepository<MovieShow,Integer>{
	@Query("SELECT s FROM MovieShow s where s.movie.movieId= :movieId")
	List<MovieShow> findByMovie(@Param("movieId") Long movieId);

}
