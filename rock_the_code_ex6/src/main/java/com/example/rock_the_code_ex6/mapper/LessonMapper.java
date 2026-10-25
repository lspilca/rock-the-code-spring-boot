package com.example.rock_the_code_ex6.mapper;

import com.example.rock_the_code_ex6.entity.Lesson;
import com.example.rock_the_code_ex6.entity.Rider;
import com.example.rock_the_code_ex6.model.CreateLessonRequest;
import com.example.rock_the_code_ex6.model.LessonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LessonMapper {

    String TIME_FORMAT = "HH:mm";

    @Mapping(target = "riderExternalId", source = "rider.externalId")
    @Mapping(target = "lessonTime", dateFormat = TIME_FORMAT)
    LessonDTO toDto(Lesson lesson);

    @Mapping(target = "rider", source = "rider")
    @Mapping(target = "lessonTime", source = "request.lessonTime", dateFormat = TIME_FORMAT)
    Lesson toEntity(CreateLessonRequest request, Rider rider);
}
