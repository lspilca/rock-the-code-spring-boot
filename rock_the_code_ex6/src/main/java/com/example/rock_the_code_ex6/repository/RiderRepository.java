package com.example.rock_the_code_ex6.repository;

import com.example.rock_the_code_ex6.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RiderRepository extends JpaRepository<Rider, Long> {

    Optional<Rider> findByExternalId(UUID externalId);
}
