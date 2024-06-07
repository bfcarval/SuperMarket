package com.supermarket.api.exception;

import com.supermarket.api.exception.data.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( value = Exception.class)
    public ResponseEntity genericException(Exception exception) {
        return new ResponseEntity(
                ErrorResponse.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity customerNotFoundException(ProductNotFoundException exception) {
        return new ResponseEntity(
                ErrorResponse.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}
