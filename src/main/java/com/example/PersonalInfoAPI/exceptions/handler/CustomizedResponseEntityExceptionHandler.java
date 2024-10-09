package com.example.PersonalInfoAPI.exceptions.handler;

import com.example.PersonalInfoAPI.exceptions.ExceptionResponse;
import com.example.PersonalInfoAPI.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler (Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(
            Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler (ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
            Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ExceptionResponse>(exceptionResponse,
                HttpStatus.NOT_FOUND);
    }



}
