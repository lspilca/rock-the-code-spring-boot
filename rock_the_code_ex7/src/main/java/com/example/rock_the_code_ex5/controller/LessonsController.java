package com.example.rock_the_code_ex5.controller;

import com.example.rock_the_code_ex5.dto.LessonRequest;
import com.example.rock_the_code_ex5.dto.LessonResponse;
import com.example.rock_the_code_ex5.service.LessonsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonsController {

    private final LessonsService lessonsService;

    @PostMapping("/rider/{riderExternalId}")
    public LessonResponse addLesson(@NotNull @PathVariable UUID riderExternalId,
                                    @Valid @RequestBody LessonRequest request) {
        return this.lessonsService.addLesson(riderExternalId, request);
    }
}
