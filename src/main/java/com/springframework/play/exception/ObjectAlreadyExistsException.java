package com.springframework.play.exception;

public class ObjectAlreadyExistsException extends Exception{
    public ObjectAlreadyExistsException(String message) {
        super(message);
    }
}
