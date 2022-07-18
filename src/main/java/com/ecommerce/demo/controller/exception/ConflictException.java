package com.ecommerce.demo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ConflictException extends RuntimeException {

    private final static String CONFLICT_MESSAGE = "Conflict has occurred";

    public ConflictException() {
        super(CONFLICT_MESSAGE);
    }

    public ConflictException(final String message) {
        super(message);
    }
}
