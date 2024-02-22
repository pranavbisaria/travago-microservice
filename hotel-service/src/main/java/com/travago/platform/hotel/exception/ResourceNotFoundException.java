package com.travago.platform.hotel.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("Resource not found on the server!!");
    }
}
