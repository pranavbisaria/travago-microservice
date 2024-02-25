package com.travago.platform.hotel.exception;

import com.travago.platform.hotel.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        Response response = Response.builder()
                .message(ex.getMessage())
                .status(NOT_FOUND).build();
        return new ResponseEntity<>(response, NOT_FOUND);
    }
}
