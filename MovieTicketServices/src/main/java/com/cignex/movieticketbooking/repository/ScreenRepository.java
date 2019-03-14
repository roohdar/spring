package com.cignex.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cignex.movieticketbooking.model.Screen;


@Repository
public interface ScreenRepository extends JpaRepository<Screen,Integer>{

}
