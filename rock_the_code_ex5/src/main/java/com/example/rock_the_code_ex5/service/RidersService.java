package com.example.rock_the_code_ex5.service;

import com.example.rock_the_code_ex5.entity.Rider;
import com.example.rock_the_code_ex5.repository.RidersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RidersService {

    private final RidersRepository ridersRepository;

    public RidersService(RidersRepository ridersRepository) {
        this.ridersRepository = ridersRepository;
    }

    public void addRider(Rider rider) {
        this.ridersRepository.save(rider);
    }
}
