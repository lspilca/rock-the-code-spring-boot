package com.example.rock_the_code_ex5.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record LessonResponse(UUID externalId, RiderResponse rider, LocalDate lessonDate,
                             LocalTime lessonTime, Integer duration) {
}
