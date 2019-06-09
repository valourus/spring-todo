package com.valourus.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Exception> handleException(Exception e) {
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
