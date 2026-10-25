package com.example.rock_the_code_ex6.service;

import com.example.rock_the_code_ex6.entity.Rider;
import com.example.rock_the_code_ex6.exception.RiderNotFoundException;
import com.example.rock_the_code_ex6.mapper.RiderMapper;
import com.example.rock_the_code_ex6.model.CreateRiderRequest;
import com.example.rock_the_code_ex6.model.RiderDTO;
import com.example.rock_the_code_ex6.repository.RiderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class RidersService {

    private final RiderRepository riderRepository;
    private final RiderMapper riderMapper;

    @Transactional
    public RiderDTO createRider(CreateRiderRequest request) {
        Rider saved = riderRepository.save(riderMapper.toEntity(request));
        return riderMapper.toDto(saved);
    }

    public RiderDTO getRiderByExternalId(UUID externalId) {
        return riderRepository.findByExternalId(externalId)
                .map(riderMapper::toDto)
                .orElseThrow(() -> new RiderNotFoundException(externalId));
    }
}
