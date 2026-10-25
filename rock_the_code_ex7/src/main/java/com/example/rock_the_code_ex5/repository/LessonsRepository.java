package com.example.rock_the_code_ex5.repository;

import com.example.rock_the_code_ex5.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}
