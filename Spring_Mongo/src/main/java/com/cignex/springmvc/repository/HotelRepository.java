package com.cignex.springmvc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cignex.springmvc.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{
	
	
	
	public List<Hotel> findByPricePerNightLessThan(int price);

}
