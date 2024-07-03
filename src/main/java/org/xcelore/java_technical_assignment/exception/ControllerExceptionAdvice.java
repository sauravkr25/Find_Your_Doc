package org.xcelore.java_technical_assignment.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(value = DoctorNotFoundException.class)
    public ResponseEntity<Object> handle(DoctorNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(value = InvalidCityException.class)
    public ResponseEntity<Object> handle(InvalidCityException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(value = PatientNotExistsException.class)
    public ResponseEntity<Object> handle(PatientNotExistsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handle(HttpMessageNotReadableException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handle(SQLIntegrityConstraintViolationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handle(MethodArgumentNotValidException e){
        return new ResponseEntity<>(e.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }
}
