package com.example.TaxiWala.exception;

public class DriverNotValidException extends RuntimeException{
    public DriverNotValidException(String message) {
        super(message);
    }
}
