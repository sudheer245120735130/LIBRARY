package com.sudheer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EnterValidElementException.class)
	public ResponseEntity<String> handleEnterValidElementException(EnterValidElementException e) {
        return new ResponseEntity<>("Enter a valid element", HttpStatus.BAD_REQUEST);
    }
}
