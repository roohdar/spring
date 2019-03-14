package com.cignex.movieticketbooking.mvccontroller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.cignex.movieticketbooking.model.Movie;

@Controller
@RequestMapping("/movies")
public class MovieContoller {


	@Autowired
	Environment environment;

	RestTemplate resttemplate=new RestTemplate();
	List<Movie> movies;

	@GetMapping
	private String index(Model model) {
		model.addAttribute("movie",new Movie());
		return "index";
	}


	@PostMapping("/addmovie")
	private String addMovie(@RequestParam("poster") MultipartFile file,@ModelAttribute Movie movie ) throws IOException {
		byte [] poster=file.getBytes();
		movie.setMoviePoster(poster);
		System.out.println(movie);
		resttemplate.postForLocation(environment.getProperty("addmovies"), movie);
		return "redirect:/movies/showall";
	}

	@PostMapping("/updatemovie")
	private String updateMovie(@ModelAttribute Movie movie ) throws IOException {
		resttemplate.postForLocation(environment.getProperty("addmovies"), movie);
		return "redirect:/movies/showall";
	}
	@PostMapping("/updateposter")
	private String updateMovie(@RequestParam("poster") MultipartFile file,@ModelAttribute Movie movie ) throws IOException {
		byte [] poster=file.getBytes();
		movie.setMoviePoster(poster);
		System.out.println(movie);
		resttemplate.postForLocation(environment.getProperty("addmovies"), movie);
		return "redirect:/movies/showall";
	}



	@GetMapping("/showall")
	private String showMovies(Model model) {
		getallmovies(model);
		return "movies";
	}
	@GetMapping("/booking")
	private String movieBooking(Model model) {
		getallmovies(model);
		return "moviesshows";
	}

	@GetMapping("/delete")	
	private String delete(@RequestParam Long movieId) {
		resttemplate.delete(environment.getProperty("addmovies")+"/{movieId}", movieId);
		return "redirect:/movies/showall";
	}
	@GetMapping("/edit")	
	private String edit(@RequestParam Long movieId,Model model) {
		model.addAttribute("movie",getmovie(movieId));
		return "updatemovie";
	}

	public Movie getmovie(Long movieId) {
		return setPoster(resttemplate.getForEntity(environment.getProperty("addmovies")+"/{movieId}", Movie.class,movieId).getBody());
	}
	

	List<Movie> getallmovies(Model model){
		movies=new ArrayList<>();
		ResponseEntity<Movie[]> responseEntity = resttemplate.getForEntity(environment.getProperty("getmovies"), Movie[].class);
		movies.addAll(Arrays.asList(responseEntity.getBody()));
		movies.forEach(m->setPoster(m));
		model.addAttribute("movies",movies);
		return movies;
	}
	
	public static Movie setPoster(Movie m) {
		File file=new File(m.getPosterPath());
		byte[] bytes;
		try {
			bytes = Files.readAllBytes(file.toPath());
			m.setMoviePoster(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}



}
