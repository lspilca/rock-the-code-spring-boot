package com.example.rock_the_code_ex5.mapper;

import com.example.rock_the_code_ex5.dto.RiderRequest;
import com.example.rock_the_code_ex5.dto.RiderResponse;
import com.example.rock_the_code_ex5.entity.Rider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RiderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    Rider toEntity(RiderRequest request);

    RiderResponse toResponse(Rider rider);
}
