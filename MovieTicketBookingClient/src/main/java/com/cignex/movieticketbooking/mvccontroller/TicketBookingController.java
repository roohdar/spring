package com.cignex.movieticketbooking.mvccontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cignex.movieticketbooking.model.Movie;
import com.cignex.movieticketbooking.model.MovieShow;

@Controller
@RequestMapping("/ticketbooking")
public class TicketBookingController {

	List<MovieShow> shows;

	RestTemplate resttemplate=new RestTemplate();
	@Autowired
	Environment environment; 

	@GetMapping("/request/{movieId}")
	private String requestBooking(@PathVariable Long movieId,Model model) {

		shows=new ArrayList<>();
		ResponseEntity<MovieShow[]> responseEntity = resttemplate.getForEntity(environment.getProperty("getallshow")+"/{movieId}", MovieShow[].class,movieId);		
		shows.addAll(Arrays.asList(responseEntity.getBody()));
		model.addAttribute("show",shows);
		if(shows.isEmpty()) {
			return "redirect:/show/addshowmoviedetails";
		}
		return "ticketbooking";
	}
	@GetMapping("/bookshow/{showId}")
	private String bookshow(@PathVariable Long showId,Model model) {
		model.addAttribute("show",getMovieShow(showId));
		return "seatselection";
	}


	
	
	@PostMapping("/bookseats")
	private String bookseats(HttpServletRequest request,Model model) {
		List<String> seats=new ArrayList<>();
		Map<String, String[]> parameters=request.getParameterMap();
		parameters.forEach((k,v)->{
			if(k.contains("seat")) seats.add(v[0].toString());
		});
		Long showId=Long.parseLong(request.getParameter("showId"));



		MovieShow show=getMovieShow(showId);
		System.out.println(show.getBookedseats());
		if(show.getBookedseats()!=null) {
			seats.addAll(Arrays.asList(show.getBookedseats()));
		}
		String[] bookedSeats = seats.stream().toArray(String[]::new);
		show.setBookedseats(bookedSeats);
		resttemplate.postForLocation(environment.getProperty("updateshow"), show);
		return "redirect:/movies/booking";
	}


	private MovieShow getMovieShow(Long showId) {
		return resttemplate.getForEntity(environment.getProperty("getshow")+"/{showId}", MovieShow.class,showId).getBody();
	}



}
