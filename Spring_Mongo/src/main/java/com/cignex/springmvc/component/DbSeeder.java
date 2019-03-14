package com.cignex.springmvc.component;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cignex.springmvc.model.Address;
import com.cignex.springmvc.model.Hotel;
import com.cignex.springmvc.model.Review;
import com.cignex.springmvc.repository.HotelRepository;

@Component
public class DbSeeder implements CommandLineRunner{
	@Autowired
	HotelRepository hotelRepository;



	@Override
	public void run(String... args) throws Exception {
		Hotel aram=new Hotel( "Hotel Aram", 700, 
				new Address("Anand", "india"),
				Arrays.asList(new Review("rahul", 8,false),
						new Review("radhika", 7, true)));
		Hotel goa=new Hotel( "Hotel Goa", 1000, 
				new Address("Goa", "india"),
				Arrays.asList(new Review("Deep", 8,false),
						new Review("Rahul", 7, true),new Review("Alpesh", 7, false),new Review("Ravi", 8, true)));
		Hotel bluelight=new Hotel( "Hotel bluelight", 1500, 
				new Address("Khandala", "india"),
				Arrays.asList(new Review("Rahul", 7, true),
						new Review("Hiren", 7, false),
						new Review("Chintan", 8, true)));
		this.hotelRepository.saveAll(Arrays.asList(aram,goa,bluelight));
	}
}
