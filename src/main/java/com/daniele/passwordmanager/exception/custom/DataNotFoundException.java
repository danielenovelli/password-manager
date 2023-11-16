package com.daniele.passwordmanager.exception.custom;

import lombok.Getter;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message) {
        super(message);
    }
}
