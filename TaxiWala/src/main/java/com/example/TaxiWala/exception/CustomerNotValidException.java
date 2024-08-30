package com.example.TaxiWala.exception;

public class CustomerNotValidException extends RuntimeException{
    public CustomerNotValidException(String message) {
        super(message);
    }
}
