package com.org.controller;

public class IdNotFoundException extends RuntimeException {
    public long timestamp;
    public int status;
    
    public IdNotFoundException(String message) {
        super(message);
    }
}

