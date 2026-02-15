package com.carrental.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handle(NotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}