package com.doziem.Order.handler;

import com.doziem.Order.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException exp){
        return ResponseEntity
                .status(NOT_FOUND)
                .body(exp.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exp){
        var errors= new HashMap<String, String >();

        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((org.springframework.validation.FieldError) error).getField();
            var message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
 return ResponseEntity
        .status(BAD_REQUEST)
        .body(new ErrorResponse(errors));
    }

    @ExceptionHandler(BusinessException.class)
        public ResponseEntity<String> handle(BusinessException exp){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exp.getMessage());
        }
}
