package com.example.rock_the_code_ex6;

import com.example.rock_the_code_ex6.entity.Rider;
import com.example.rock_the_code_ex6.exception.RiderNotFoundException;
import com.example.rock_the_code_ex6.mapper.RiderMapper;
import com.example.rock_the_code_ex6.model.RiderDTO;
import com.example.rock_the_code_ex6.repository.RiderRepository;
import com.example.rock_the_code_ex6.service.RidersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetRiderByExternalIdTests {

    @Mock
    private RiderRepository riderRepository;

    @Mock
    private RiderMapper riderMapper;

    @InjectMocks
    private RidersService ridersService;

    @Test
    @DisplayName("""
            GIVEN an external ID for a rider that exists
            WHEN retrieving the rider by external ID
            THEN the rider details are returned
            """)
    public void test1() {
        UUID externalId = UUID.randomUUID();

        Rider rider = new Rider();
        rider.setId(1L);
        rider.setName("John");
        rider.setExternalId(externalId);

        RiderDTO riderDTO = new RiderDTO(externalId, "John");

        when(riderRepository.findByExternalId(externalId))
                .thenReturn(Optional.of(rider));

        when(riderMapper.toDto(rider))
                .thenReturn(riderDTO);

        RiderDTO returned = ridersService.getRiderByExternalId(externalId);

        assertNotNull(returned);
        assertEquals(externalId, returned.getExternalId());
        assertEquals("John", returned.getName());

        verify(riderRepository, times(1))
                .findByExternalId(externalId);
        verify(riderMapper, times(1))
                .toDto(rider);
    }

    @Test
    @DisplayName("""
            GIVEN an external ID for a rider that doesn't exist
            WHEN retrieving the rider by external ID
            THEN a RiderNotFoundException is thrown
            """)
    public void test2() {
        UUID externalId = UUID.randomUUID();

        when(riderRepository.findByExternalId(externalId))
                .thenReturn(Optional.empty());

        assertThrows(RiderNotFoundException.class,
                () -> ridersService.getRiderByExternalId(externalId));

        verify(riderMapper, never())
                .toDto(any());
    }
}
