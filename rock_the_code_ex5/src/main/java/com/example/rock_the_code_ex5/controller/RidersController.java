package com.example.rock_the_code_ex5.controller;

import com.example.rock_the_code_ex5.entity.Rider;
import com.example.rock_the_code_ex5.service.RidersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/riders")
public class RidersController {

    private final RidersService ridersService;

    public RidersController(RidersService ridersService) {
        this.ridersService = ridersService;
    }

    @PostMapping
    public void createRider(@RequestBody Rider rider) {
        ridersService.addRider(rider);
    }
}
