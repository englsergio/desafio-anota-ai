package com.lsalmeida.desafioanotaai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<RestErrorMessage> CategoryNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestErrorMessage(404, "message"));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<RestErrorMessage> ProductNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestErrorMessage(404, "message"));
    }

}
