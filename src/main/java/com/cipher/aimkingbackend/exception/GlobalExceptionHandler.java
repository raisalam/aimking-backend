package com.cipher.aimkingbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors()
        .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<String> handleInvalidCredentialException(ApplicationException ex) {
    System.out.println("ApplicationException " + ex.getDetailMessage());
    return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
        .body("{\"error\":\"" + ex.getMessage() + "\"}");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception ex) {
    ex.printStackTrace();
    System.out.println("Global Exception is called. Exception message = " + ex.getMessage());
    String message = "Error";
    return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
        .body("{\"error\":\"" + message + "\"}");
  }
}
