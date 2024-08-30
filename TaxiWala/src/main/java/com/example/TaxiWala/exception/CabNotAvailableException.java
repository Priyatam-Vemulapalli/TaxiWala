package com.example.TaxiWala.exception;


public class CabNotAvailableException extends RuntimeException{
    public CabNotAvailableException(String message){
        super(message);
    }
}
