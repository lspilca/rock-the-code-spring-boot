package org.example.rock_the_code_ex2.controllers;

import org.example.rock_the_code_ex2.dtos.Rider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RidersController {

	@GetMapping("/api/riders")
	public List<Rider> getRiders() {
		return List.of(new Rider("Lara"), new Rider("John"));
	}
}
