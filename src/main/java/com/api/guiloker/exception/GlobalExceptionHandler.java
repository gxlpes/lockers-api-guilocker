package com.api.guiloker.exception;

import com.api.guiloker.exception.types.LockerAlreadyRentedException;
import com.api.guiloker.exception.types.LockerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LockerNotFoundException.class)
    public ResponseEntity<ErrorObject> handleLockerNotFound(LockerNotFoundException ex, WebRequest request) {

        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());

        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LockerAlreadyRentedException.class)
    public ResponseEntity<ErrorObject> handleLockerAlreadyRented(LockerAlreadyRentedException ex, WebRequest request) {

        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());

        return new ResponseEntity<>(errorObject, HttpStatus.CONFLICT);
    }

}