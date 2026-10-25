package com.example.rock_the_code_ex5.repository;

import com.example.rock_the_code_ex5.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RidersRepository extends JpaRepository<Rider, Long> {
}
