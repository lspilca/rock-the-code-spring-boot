package com.example.rock_the_code_ex5.mapper;

import com.example.rock_the_code_ex5.dto.LessonRequest;
import com.example.rock_the_code_ex5.dto.LessonResponse;
import com.example.rock_the_code_ex5.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RiderMapper.class)
public interface LessonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "rider", ignore = true)
    Lesson toEntity(LessonRequest request);

    LessonResponse toResponse(Lesson lesson);
}
