package com.konstl.dormitories.exception.api;

import com.konstl.dormitories.exception.BasicException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class UnauthorizedException extends BasicException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(String message) {

        super(HttpStatus.UNAUTHORIZED, message);
    }

    public UnauthorizedException(String message, Throwable cause) {

        super(HttpStatus.UNAUTHORIZED, message, cause);
    }
}
