package com.Micro.demo.ExceptionHandling;

public class TeamNotExists extends RuntimeException{
    public TeamNotExists() {
    }
    public TeamNotExists(String message) {
        super(message);
    }
}
