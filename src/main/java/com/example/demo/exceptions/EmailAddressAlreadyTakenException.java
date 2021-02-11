package com.example.demo.exceptions;

public class EmailAddressAlreadyTakenException extends RuntimeException {
    public EmailAddressAlreadyTakenException(String message) {
        super(message);
    }
}