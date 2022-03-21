package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class SportsExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.getMessage());
    }
}
