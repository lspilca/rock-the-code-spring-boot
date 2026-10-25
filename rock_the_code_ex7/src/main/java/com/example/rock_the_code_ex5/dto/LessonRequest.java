package com.example.rock_the_code_ex5.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record LessonRequest(
        @NotNull(message = "Lesson date is required.")
        @FutureOrPresent(message = "Lesson must not be in the past.")
        LocalDate lessonDate,

        @NotNull(message = "Lesson time is required.")
        LocalTime lessonTime,

        @NotNull(message = "The duration is required.")
        @Min(value = 30, message = "The lesson must be at least 30 minutes.")
        @Max(value = 50, message = "The lesson must be maximum 50 minutes")
        Integer duration
) {
}
