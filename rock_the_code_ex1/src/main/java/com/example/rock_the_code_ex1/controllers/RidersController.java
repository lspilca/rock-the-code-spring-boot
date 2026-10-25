package com.example.rock_the_code_ex1.controllers;

import com.example.rock_the_code_ex1.dtos.Rider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RidersController {

	@GetMapping("/api/riders")
	public List<Rider> findAllRiders() {
		return List.of(new Rider("Lara"), new Rider("John"));
	}
}
