package com.LogicaBeans.LogicaEntityTest.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
