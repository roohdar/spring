package com.cignex.movieticketbooking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.movieticketbooking.model.MovieShow;
import com.cignex.movieticketbooking.repository.MovieRepository;
import com.cignex.movieticketbooking.repository.ShowRepository;

@RestController
@RequestMapping("/shows")
public class ShowRestController {

	@Autowired
	ShowRepository showRepository;
	@Autowired
	MovieRepository movieRepository;
	
	@PostMapping
	private void addShows(@RequestBody List<MovieShow> shows) {
		showRepository.saveAll(shows);
	} 
	
	@PostMapping("/update")
	private void updateShow(@RequestBody MovieShow show) {
		showRepository.save(show);
	}
	
	@GetMapping("/getAll/{movieId}")
	private List<MovieShow> getAllShow(@PathVariable("movieId") long movieId){
		return showRepository.findByMovie(movieId);
	}
	
	
	@GetMapping("/{showId}")
	private MovieShow getShow(@PathVariable Integer showId){
		return showRepository.findById(showId).get();
	}
	
	
	
	
}
