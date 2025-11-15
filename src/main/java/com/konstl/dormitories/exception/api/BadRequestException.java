package com.konstl.dormitories.exception.api;

import com.konstl.dormitories.exception.BasicException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class BadRequestException extends BasicException {

    @Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException(String message) {

        super(HttpStatus.BAD_REQUEST, message);
    }

    public BadRequestException(String message, Throwable cause) {

        super(HttpStatus.BAD_REQUEST, message, cause);
    }
}
