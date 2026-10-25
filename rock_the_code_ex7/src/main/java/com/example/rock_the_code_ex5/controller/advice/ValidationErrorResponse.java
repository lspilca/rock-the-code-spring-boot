package com.example.rock_the_code_ex5.controller.advice;

import java.util.List;

public record ValidationErrorResponse(String message, List<FieldViolation> errors) {
}
