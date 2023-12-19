package com.Micro.demo.ExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorHandler {
    String ErrorMessage;
    HttpStatus httpStatus;


    public ErrorHandler(String errorMessage, HttpStatus httpStatus) {
        ErrorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
}
