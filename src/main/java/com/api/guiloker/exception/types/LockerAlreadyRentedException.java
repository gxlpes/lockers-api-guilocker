package com.api.guiloker.exception.types;

import java.io.Serial;

public class LockerAlreadyRentedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1l;

    public LockerAlreadyRentedException(String message) {
        super(message);
    }
}
