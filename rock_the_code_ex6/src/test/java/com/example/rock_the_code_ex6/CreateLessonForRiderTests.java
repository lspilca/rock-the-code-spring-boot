package com.example.rock_the_code_ex6;

import com.example.rock_the_code_ex6.entity.Lesson;
import com.example.rock_the_code_ex6.entity.Rider;
import com.example.rock_the_code_ex6.exception.RiderNotFoundException;
import com.example.rock_the_code_ex6.mapper.LessonMapper;
import com.example.rock_the_code_ex6.model.CreateLessonRequest;
import com.example.rock_the_code_ex6.model.LessonDTO;
import com.example.rock_the_code_ex6.repository.LessonRepository;
import com.example.rock_the_code_ex6.repository.RiderRepository;
import com.example.rock_the_code_ex6.service.LessonsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreateLessonForRiderTests {

    private LessonRepository lessonRepository;
    private RiderRepository riderRepository;
    private LessonMapper lessonMapper;
    private LessonsService lessonsService;

    @BeforeEach
    public void initBefore() {
        lessonRepository = mock(LessonRepository.class);
        riderRepository = mock(RiderRepository.class);
        lessonMapper = mock(LessonMapper.class);

        lessonsService = new LessonsService(lessonRepository, riderRepository, lessonMapper);
    }

    @Test
    @DisplayName("""
            GIVEN a rider ID for a rider that doesn't exist
            WHEN trying to add a new lesson
            THEN a RiderNotFoundException is thrown
            """)
    public void test1() {
        UUID riderID = UUID.randomUUID();
        CreateLessonRequest createLessonRequest = new CreateLessonRequest();

        when(riderRepository.findByExternalId(riderID))
                .thenThrow(RiderNotFoundException.class);

        assertThrows(RiderNotFoundException.class,
                () -> lessonsService.createLessonForRider(riderID, createLessonRequest));

        verify(lessonRepository, never())
                .save(any());
    }

    @Test
    @DisplayName("""
            GIVEN a rider ID that does exist and a lesson request
            WHEN trying to add a new lesson
            THEN the lesson is stored in the system
            """)
    public void test2() {
        UUID riderID = UUID.randomUUID();
        CreateLessonRequest createLessonRequest = new CreateLessonRequest(
                LocalDate.now(),
                "12:00",
                40
        );
        Rider rider = new Rider();
        rider.setName("John");
        rider.setId(1L);
        rider.setExternalId(riderID);

        Lesson mappedLesson = new Lesson();
        mappedLesson.setLessonDate(LocalDate.now());
        mappedLesson.setLessonTime(LocalTime.parse("12:00"));
        mappedLesson.setDuration(40);

        Lesson savedLesson = new Lesson();
        savedLesson.setId(1L);
        savedLesson.setExternalId(UUID.randomUUID());
        savedLesson.setLessonDate(LocalDate.now());
        savedLesson.setLessonTime(LocalTime.parse("12:00"));
        savedLesson.setDuration(40);

        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setDuration(40);
        lessonDTO.setLessonDate(LocalDate.now());
        lessonDTO.setLessonTime("12:00");
        lessonDTO.setExternalId(savedLesson.getExternalId());

        when(riderRepository.findByExternalId(riderID))
                .thenReturn(Optional.of(rider));

        when(lessonMapper.toEntity(createLessonRequest, rider))
                .thenReturn(mappedLesson);

        when(lessonRepository.save(mappedLesson))
                .thenReturn(savedLesson);

        when(lessonMapper.toDto(savedLesson))
                .thenReturn(lessonDTO);

        LessonDTO returned = lessonsService.createLessonForRider(riderID, createLessonRequest);

        assertNotNull(returned);
        assertEquals(40, returned.getDuration());

        verify(lessonRepository, times(1))
                .save(mappedLesson);
    }
}
