package com.example.rock_the_code_ex6.service;

import com.example.rock_the_code_ex6.entity.Lesson;
import com.example.rock_the_code_ex6.entity.Rider;
import com.example.rock_the_code_ex6.exception.RiderNotFoundException;
import com.example.rock_the_code_ex6.mapper.LessonMapper;
import com.example.rock_the_code_ex6.model.CreateLessonRequest;
import com.example.rock_the_code_ex6.model.LessonDTO;
import com.example.rock_the_code_ex6.repository.LessonRepository;
import com.example.rock_the_code_ex6.repository.RiderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class LessonsService {

    private final LessonRepository lessonRepository;
    private final RiderRepository riderRepository;
    private final LessonMapper lessonMapper;

    @Transactional
    public LessonDTO createLessonForRider(UUID riderExternalId, CreateLessonRequest request) {
        Rider rider = riderRepository.findByExternalId(riderExternalId)
                .orElseThrow(() -> new RiderNotFoundException(riderExternalId));
        Lesson saved = lessonRepository.save(lessonMapper.toEntity(request, rider));
        return lessonMapper.toDto(saved);
    }
}
