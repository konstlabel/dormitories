package com.konstl.dormitories.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class BasicException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final HttpStatus status;

    public BasicException(HttpStatus status, String message) {

        super(message);
        this.status = status;
    }

    public BasicException(HttpStatus status, String message, Throwable exception) {

        super(message, exception);
        this.status = status;
    }
}
