package com.example.rock_the_code_ex5.controller;

import com.example.rock_the_code_ex5.dto.RiderRequest;
import com.example.rock_the_code_ex5.dto.RiderResponse;
import com.example.rock_the_code_ex5.service.RidersService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/riders")
@RequiredArgsConstructor
public class RidersController {

    private final RidersService ridersService;

    @PostMapping
    public RiderResponse addRider(@Valid @RequestBody RiderRequest request) {
        return this.ridersService.addRider(request);
    }

    @GetMapping("/{externalId}")
    public RiderResponse findByExternalId(@NotNull @PathVariable UUID externalId) {
        return this.ridersService.findByExternalId(externalId);
    }
}
