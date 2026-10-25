package com.example.rock_the_code_ex5.service;

import com.example.rock_the_code_ex5.dto.LessonRequest;
import com.example.rock_the_code_ex5.dto.LessonResponse;
import com.example.rock_the_code_ex5.entity.Lesson;
import com.example.rock_the_code_ex5.entity.Rider;
import com.example.rock_the_code_ex5.mapper.LessonMapper;
import com.example.rock_the_code_ex5.repository.LessonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonsService {

    private final LessonsRepository lessonsRepository;
    private final RidersService ridersService;
    private final LessonMapper lessonMapper;

    public LessonResponse addLesson(UUID riderExternalId, LessonRequest request) {
        Rider rider = this.ridersService.getRider(riderExternalId);
        Lesson lesson = this.lessonMapper.toEntity(request);
        lesson.setRider(rider);
        return this.lessonMapper.toResponse(this.lessonsRepository.save(lesson));
    }
}
