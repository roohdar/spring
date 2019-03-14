package com.cignex.movieticketbooking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.movieticketbooking.model.Screen;
import com.cignex.movieticketbooking.repository.ScreenRepository;

@RestController
@RequestMapping("/screen")
public class ScreenRestController {

	@Autowired
	ScreenRepository screenRepository;

	@GetMapping("/addSeats")
	private String addScreenSeats() {

		Screen screen = new Screen();
		screen.setScreenNumber(1);
		screen.setPlatinumSeats(platinumSeats);
		screen.setGoldSeats(goldSeats);
		screen.setSilverSeats(silverSeats);
		screenRepository.save(screen);

		screen = new Screen();
		screen.setScreenNumber(2);
		screen.setPlatinumSeats(platinumSeats);
		screen.setGoldSeats(goldSeats);
		screen.setSilverSeats(silverSeats);
		screenRepository.save(screen);

		screen = new Screen();
		screen.setScreenNumber(3);
		screen.setPlatinumSeats(platinumSeats);
		screen.setGoldSeats(goldSeats);
		screen.setSilverSeats(silverSeats);
		screenRepository.save(screen);

		return "Screens are added";
	}

	@GetMapping
	private List<Screen> getallScreens() {
		return screenRepository.findAll();
	}

	private String platinumSeats[] = { "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "B1", "B2", "B3",
			"B4", "B5", "B6", "B7", "B8", "B9", "B10" };
	private String goldSeats[] = { "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "D1", "D2", "D3", "D4",
			"D5", "D6", "D7", "D8", "D9", "D10" };
	private String silverSeats[] = { "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "F1", "F2", "F3",
			"F4", "F5", "F6", "F7", "F8", "F9", "F10" };

}
