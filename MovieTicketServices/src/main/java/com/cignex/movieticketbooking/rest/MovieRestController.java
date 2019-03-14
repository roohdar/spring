package com.cignex.movieticketbooking.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.movieticketbooking.model.Movie;
import com.cignex.movieticketbooking.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
@MultipartConfig
public class MovieRestController {



	@Autowired
	MovieRepository repository;
	private Movie movie;

	private final String posterURL="C:\\Users\\rahul.patidar\\Pictures\\posters\\";

	@PersistenceContext
	private EntityManager entityManager;
	

	@PostMapping
	private String addMovie(@RequestBody Movie m) throws IOException {
		if(m.getMoviePoster()!=null) {
			m.setPosterPath(posterURL+m.getMovieName()+".jpg");
			Path path=Paths.get(posterURL+m.getMovieName()+".jpg");
			Files.write(path, m.getMoviePoster());
		}
		movie=	repository.save(m);
		return "Added"+ movie.toString();
	}
	
	@GetMapping("/all")
	private List<Movie> getAllMovies(){
		List<Movie> movies=repository.findAll();
		
		return movies;
	}

	@GetMapping("/{movieId}")
	private Movie getMovie(@PathVariable long movieId){
		return repository.findById(movieId).get();
		
	}

	@DeleteMapping("/{movieId}")
	private int deleteMovie(@PathVariable long movieId) {
		Movie movie=getMovie(movieId);
		repository.deleteById(movieId);
		new File(posterURL+movie.getMovieName()+".jpg").delete();
		return 1;
	}
	
	
	

}
