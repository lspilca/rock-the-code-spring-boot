package com.example.rock_the_code_ex5.service;

import com.example.rock_the_code_ex5.dto.RiderRequest;
import com.example.rock_the_code_ex5.dto.RiderResponse;
import com.example.rock_the_code_ex5.entity.Rider;
import com.example.rock_the_code_ex5.mapper.RiderMapper;
import com.example.rock_the_code_ex5.repository.RidersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RidersService {

    private final RidersRepository ridersRepository;
    private final RiderMapper riderMapper;

    public RiderResponse addRider(RiderRequest request) {
        return this.riderMapper.toResponse(this.ridersRepository.save(this.riderMapper.toEntity(request)));
    }

    @Transactional(readOnly = true)
    public RiderResponse findByExternalId(UUID externalId) {
        return this.riderMapper.toResponse(getRider(externalId));
    }

    @Transactional(readOnly = true)
    public Rider getRider(UUID externalId) {
        return this.ridersRepository.findByExternalId(externalId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Rider with external id " + externalId + " not found"));
    }
}
