package com.saude.agenda.api.exception;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleExceptionMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<FieldError> errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorValidation::new).toList());
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity handleUnexpectedTypeException(UnexpectedTypeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
