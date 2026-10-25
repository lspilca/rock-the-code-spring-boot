package com.example.rock_the_code_ex5.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RiderRequest(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 20, message = "Name can have maximum 20 characters")
        String name) {
}
