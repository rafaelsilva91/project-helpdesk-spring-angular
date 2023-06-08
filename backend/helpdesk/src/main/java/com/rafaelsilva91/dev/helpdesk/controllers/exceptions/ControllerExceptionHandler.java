package com.rafaelsilva91.dev.helpdesk.controllers.exceptions;

import com.rafaelsilva91.dev.helpdesk.services.exceptions.ObjectNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExceptions.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundExceptions ex
                                                                , HttpServletRequest request){

        StandardError error = new StandardError(System.currentTimeMillis()
                , HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

}
