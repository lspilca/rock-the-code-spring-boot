package com.example.rock_the_code_ex6.mapper;

import com.example.rock_the_code_ex6.entity.Rider;
import com.example.rock_the_code_ex6.model.CreateRiderRequest;
import com.example.rock_the_code_ex6.model.RiderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RiderMapper {

    RiderDTO toDto(Rider rider);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    Rider toEntity(CreateRiderRequest request);
}
