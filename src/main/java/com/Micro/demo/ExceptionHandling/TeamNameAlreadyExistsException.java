package com.Micro.demo.ExceptionHandling;

public class TeamNameAlreadyExistsException extends RuntimeException{

    public TeamNameAlreadyExistsException() {
    }

    public TeamNameAlreadyExistsException(String message) {
        super(message);
    }
}
