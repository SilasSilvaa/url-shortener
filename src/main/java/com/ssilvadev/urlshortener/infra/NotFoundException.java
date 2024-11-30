package com.ssilvadev.urlshortener.infra;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
