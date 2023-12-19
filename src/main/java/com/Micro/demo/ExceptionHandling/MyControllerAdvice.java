package com.Micro.demo.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmptyInput(EmployeeNotFoundException employeeNotFoundException) {
        ErrorHandler errorHandler = new ErrorHandler
                        (employeeNotFoundException.getMessage(),
                         HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorHandler, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TeamNameAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmptyInput(TeamNameAlreadyExistsException teamNameAlreadyExistsException ) {
        ErrorHandler errorHandler = new ErrorHandler
                (teamNameAlreadyExistsException.getMessage(),
                        HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorHandler, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TeamNotExists.class)
    public ResponseEntity<Object> handleEmptyInput(TeamNotExists teamNotExists ) {
        ErrorHandler errorHandler = new ErrorHandler
                (teamNotExists.getMessage(),
                        HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorHandler, HttpStatus.NOT_FOUND);
    }

}
