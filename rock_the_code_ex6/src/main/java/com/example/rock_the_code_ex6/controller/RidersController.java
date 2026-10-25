package com.example.rock_the_code_ex6.controller;

import com.example.rock_the_code_ex6.api.RidersApi;
import com.example.rock_the_code_ex6.model.CreateRiderRequest;
import com.example.rock_the_code_ex6.model.RiderDTO;
import com.example.rock_the_code_ex6.service.RidersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class RidersController implements RidersApi {

    private final RidersService ridersService;

    @Override
    public ResponseEntity<RiderDTO> createRider(CreateRiderRequest createRiderRequest) {
        RiderDTO created = ridersService.createRider(createRiderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    public ResponseEntity<RiderDTO> getRiderByExternalId(UUID externalId) {
        return ResponseEntity.ok(ridersService.getRiderByExternalId(externalId));
    }
}
