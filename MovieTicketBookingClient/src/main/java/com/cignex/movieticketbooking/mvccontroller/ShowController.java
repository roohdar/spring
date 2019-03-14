package com.cignex.movieticketbooking.mvccontroller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.cignex.movieticketbooking.model.Movie;
import com.cignex.movieticketbooking.model.Screen;
import com.cignex.movieticketbooking.model.MovieShow;

@Controller
@RequestMapping("/show")
public class ShowController {

	RestTemplate resttemplate=new RestTemplate();
	@Autowired
	Environment environment;

	private List<Screen> screens;
	private List<Movie> movies;
	private List<MovieShow> shows=new ArrayList<>();
	Movie movie;
	MovieShow show;
	Screen screen;
	@GetMapping("/addshowmoviedetails")
	private String addshowmoviedetails(Model model) {
		movies =new ArrayList<>();
		ResponseEntity<Movie[]> responseEntity = resttemplate.getForEntity(environment.getProperty("getmovies"), Movie[].class);
		movies.addAll(Arrays.asList(responseEntity.getBody()));
		model.addAttribute("movies",movies);
		model.addAttribute("action","moviedetail");
		return "addmovieshow";
	}

	@PostMapping("/addshow")
	private String addShow(Model model,
			@RequestParam("movieId") Integer movieId,
			@RequestParam("shownumber") Integer shownumber,
			@RequestParam("showdate") Date showdate) {


		model.addAttribute("action","movie");
		model.addAttribute("shownumber",shownumber);
		show=new MovieShow();
		screens=new ArrayList<>();
		movie=resttemplate.getForEntity(environment.getProperty("addmovies")+"/{movieId}", Movie.class,movieId).getBody();
		ResponseEntity<Screen[]> entity=resttemplate.getForEntity(environment.getProperty("getscreen"), Screen[].class); 
		screens.addAll(Arrays.asList(entity.getBody()));
		model.addAttribute("screen",screens);
		show.setMovie(movie);
		show.setShowDate(showdate);
		model.addAttribute("show",show);
		return "addmovieshow";
	}


	@PostMapping("/submitshow")
	private String submitshow(@ModelAttribute MovieShow movieShow,HttpServletRequest request, @RequestParam("showNumber") int shownumber) {
		shows=new ArrayList<>();

		for(int i=0; i<shownumber; i++) {
			MovieShow show=new MovieShow();
			show.setMovie(movieShow.getMovie());
			show.setShowDate(movieShow.getShowDate());
			String time=request.getParameter("showtime"+i)+":00";
			show.setPlatinumPrice(Integer.parseInt(request.getParameter("platinum"+i)));
			show.setGoldPrice(Integer.parseInt(request.getParameter("gold"+i)));
			show.setSilverPrice(Integer.parseInt(request.getParameter("silver"+i)));
			show.setShowTime(Time.valueOf(time));
			show.setMovie(movie);
			int screennum=Integer.parseInt(request.getParameter("screen"+i));
			
			screen=screens.stream().filter(s->s.getScreenNumber()==screennum).findFirst().get();
			show.setScreen(screen);
			shows.add(show);
		}


		resttemplate.postForLocation(environment.getProperty("saveshow"), shows);
		return "redirect:/movies/showall";

	}


}
