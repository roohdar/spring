package com.cignex.movieticketbooking.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MvcConfiguration{
	@GetMapping
	private String index() {
		return "index";
	}

}