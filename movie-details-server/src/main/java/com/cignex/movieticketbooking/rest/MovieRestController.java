package com.cignex.movieticketbooking.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cignex.movieticketbooking.exception.MovieException;
import com.cignex.movieticketbooking.model.Movie;
import com.cignex.movieticketbooking.repository.MovieRepository;

@MultipartConfig
@CrossOrigin
@RestController
@RequestMapping(value = "/movies")
public class MovieRestController {

	@Autowired
	MovieRepository repository;

	private static Movie movie;

	private final String posterURL = "C:\\Users\\rahul.patidar\\Pictures\\posters\\";

	@PostMapping("/{movieName}/saveposter")
	private HttpStatus saveImage(@RequestPart("poster") MultipartFile file, @PathVariable String movieName)
			throws IOException {
		Path path = Paths.get(posterURL + movieName + ".jpg");
		Files.write(path, file.getBytes());
		return HttpStatus.CREATED;
	}

	@PostMapping(value = "/add")
	private Resource<Movie> addMovie(@Valid @RequestBody Movie movie) throws IOException {
		this.movie = repository.findByMovieName(movie.getMovieName());
		if (this.movie != null) {
			throw new MovieException.MovieAlreadyAwailabeException(
					movie.getMovieName() + " is already awailable in list");
		}
		movie.setPosterPath(posterURL + movie.getMovieName() + ".jpg");
		for (String a : movie.getMovieActors()) {
			System.out.println(a);
		}
		movie = repository.save(movie);
		Resource<Movie> resource = new Resource<Movie>(movie);
		ControllerLinkBuilder builder = linkTo(methodOn(this.getClass()).getAllMovies());
		resource.add(builder.withRel("All-Movies"));
		return resource;

	}

	@PostMapping("/update")
	private String updateMovie(@RequestBody Movie m) throws IOException {
		/*
		 * if (m.getMoviePoster() != null) { m.setPosterPath(posterURL +
		 * m.getMovieName() + ".jpg"); Path path = Paths.get(posterURL +
		 * m.getMovieName() + ".jpg"); Files.write(path, m.getMoviePoster()); }
		 */
		movie = repository.save(m);
		return "Added" + movie.toString();
	}

	@GetMapping("/all")
	protected List<Movie> getAllMovies() {
		List<Movie> movies = repository.findAll();
		return movies;
	}

	/*
	 * @GetMapping("/get/{movieId}") private Movie getMovie(@PathVariable long
	 * movieId) { return repository.findById(movieId).get();
	 * 
	 * }
	 */

	@GetMapping("/get/{movieName}")
	private Resource<Movie> getMovieByname(@PathVariable String movieName) {
		movie = repository.findByMovieName(movieName);
		if (movie == null) {
			throw new MovieException.MovieNotFoundException("There is no Movie like " + movieName);
		}
		Resource<Movie> resource = new Resource<Movie>(movie);

		ControllerLinkBuilder builder = linkTo(methodOn(this.getClass()).getAllMovies());
		resource.add(builder.withRel("All-Movies"));

		return resource;

	}

	/*
	 * @DeleteMapping("/delete/{movieId}") private int deleteMovie(@PathVariable
	 * long movieId) { Movie movie = getMovie(movieId);
	 * repository.deleteById(movieId); new File(posterURL + movie.getMovieName() +
	 * ".jpg").delete(); return 1; }
	 */

}
