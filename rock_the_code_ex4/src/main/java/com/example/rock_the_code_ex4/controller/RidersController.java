package com.example.rock_the_code_ex4.controller;

import com.example.rock_the_code_ex4.generated.api.RidersApi;
import com.example.rock_the_code_ex4.generated.model.Rider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class RidersController implements RidersApi {

    private final List<Rider> riders;

    public RidersController() {
        this.riders = new ArrayList<>();
    }

    @Override
    public synchronized ResponseEntity<Rider> addRider(Rider rider) {
        boolean exists = this.riders.stream()
                .anyMatch(r -> Objects.equals(r.getId(), rider.getId()));
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        this.riders.add(rider);
        return ResponseEntity.status(HttpStatus.CREATED).body(rider);
    }

    @Override
    public synchronized ResponseEntity<Rider> getRiderById(Long riderId) {
        var rider = this.riders.stream()
                .filter(r -> Objects.equals(r.getId(), riderId))
                .findAny();
        return ResponseEntity.of(rider);
    }

}
