package com.ssilvadev.urlshortener.infra;

import com.ssilvadev.urlshortener.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> generalException(Exception e){
        ExceptionDTO exception = new ExceptionDTO(e.getMessage(), "500");

        return ResponseEntity.internalServerError().body(exception);
    }
}
