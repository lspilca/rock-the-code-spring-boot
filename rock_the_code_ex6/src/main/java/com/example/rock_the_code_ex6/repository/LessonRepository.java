package com.example.rock_the_code_ex6.repository;

import com.example.rock_the_code_ex6.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
