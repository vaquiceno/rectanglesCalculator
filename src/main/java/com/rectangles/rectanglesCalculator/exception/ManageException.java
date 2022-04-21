package com.rectangles.rectanglesCalculator.exception;

import com.rectangles.rectanglesCalculator.dto.error.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ManageException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handlerValidation(ValidationException ex, WebRequest request){
        return new ResponseEntity<>(new ResponseError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
