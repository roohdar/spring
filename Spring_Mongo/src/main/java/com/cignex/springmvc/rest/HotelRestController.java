package com.cignex.springmvc.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.springmvc.model.Hotel;
import com.cignex.springmvc.repository.HotelRepository;

@RestController
@RequestMapping("/hotel")
public class HotelRestController {

	@Autowired
	HotelRepository hotelRepository;

	
	@GetMapping("/all")
	private List<Hotel> getHotels(){
		return this.hotelRepository.findAll();
	}

	
	@PostMapping
	private void addHotel(@RequestBody Hotel hotel) {
		hotelRepository.insert(hotel);
	}
	@PutMapping
	private void updateHotel(@RequestBody Hotel hotel) {
		hotelRepository.save(hotel);
	}
	@DeleteMapping("/{id}")
	private void deleteHotel(@PathVariable String id) {
		hotelRepository.deleteById(id);
	}

	
	@GetMapping("/{id}")
	private Optional<Hotel> getHotelById(@PathVariable String id) {
		return hotelRepository.findById(id);
	}
	

}

