package com.cignex.security.resourse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResourse {

	@GetMapping
	private String hello() {
		return "HEllo";
	}

}
