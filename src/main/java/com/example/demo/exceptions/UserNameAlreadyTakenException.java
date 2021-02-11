package com.example.demo.exceptions;

public class UserNameAlreadyTakenException extends RuntimeException {
    public UserNameAlreadyTakenException(String message) {
        super(message);
    }
}