package com.api.guiloker.exception.types;

public class LockerNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public LockerNotFoundException(String message) {
        super(message);
    }
}