package com.example.rock_the_code_ex6.controller;

import com.example.rock_the_code_ex6.api.LessonsApi;
import com.example.rock_the_code_ex6.model.CreateLessonRequest;
import com.example.rock_the_code_ex6.model.LessonDTO;
import com.example.rock_the_code_ex6.service.LessonsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class LessonsController implements LessonsApi {

    private final LessonsService lessonsService;

    @Override
    public ResponseEntity<LessonDTO> createLessonForRider(UUID externalId, CreateLessonRequest createLessonRequest) {
        LessonDTO created = lessonsService.createLessonForRider(externalId, createLessonRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
