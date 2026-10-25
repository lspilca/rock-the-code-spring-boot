package com.example.rock_the_code_ex6.exception;

import java.util.UUID;

public class RiderNotFoundException extends RuntimeException {

    public RiderNotFoundException(UUID externalId) {
        super("Rider not found: " + externalId);
    }
}
