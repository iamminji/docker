package com.example.simpletokenreatelimitter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SimpleControllerAdvice {

    @ExceptionHandler(EmptyTokenBucketException.class)
    public ResponseEntity<String> handleEmptyTokenException(EmptyTokenBucketException e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
