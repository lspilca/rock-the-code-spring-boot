package com.example.rock_the_code_ex3.controller;

import com.example.rock_the_code_ex3.dtos.Rider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/riders")
public class RidersController {

    private final List<Rider> riders;

    public RidersController() {
        this.riders = new ArrayList<>();
    }

    @PostMapping
    public void addRider(@RequestBody Rider rider) {
        this.riders.add(rider);
    }

    @GetMapping
    public List<Rider> findAllRiders() {
        return this.riders;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rider> findRiderById(@PathVariable int id) {
        Optional<Rider> rider = this.riders.stream()
                .filter(r -> r.getId() == id)
                .findAny();

        return ResponseEntity.of(rider);
    }

    @PutMapping("/{id}")
    public void replaceRider(@PathVariable int id, @RequestBody Rider rider) {
        for (int i = 0; i < this.riders.size(); i++) {
            if (this.riders.get(i).getId() == id) {
                this.riders.remove(i);
                this.riders.add(i, rider);
            }
        }
    }

    @PatchMapping("/{id}/{name}")
    public void changeRiderName(@PathVariable int id, @PathVariable String name) {
        for (int i = 0; i < this.riders.size(); i++) {
            if (this.riders.get(i).getId() == id) {
                this.riders.get(i).setName(name);
            }
        }
    }

    @DeleteMapping("/{id}")
    public void removeRider(@PathVariable int id) {
        for (int i = 0; i < this.riders.size(); i++) {
            if (this.riders.get(i).getId() == id) {
                this.riders.remove(i);
            }
        }
    }
}
