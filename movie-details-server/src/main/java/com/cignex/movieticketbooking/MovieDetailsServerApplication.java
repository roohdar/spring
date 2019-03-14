package com.cignex.movieticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieDetailsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDetailsServerApplication.class, args);
	}

}
