package com.Micro.demo.ExceptionHandling;

public class EmployeeNotFoundException extends RuntimeException{


    public EmployeeNotFoundException(String message) {
        super(message);
    }

}
