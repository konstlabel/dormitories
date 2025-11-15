package com.konstl.dormitories.exception.api;

import com.konstl.dormitories.exception.BasicException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class AppException extends BasicException {

    @Serial
    private static final long serialVersionUID = 1L;

    public AppException(String message) {

        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public AppException(String message, Throwable cause) {

        super(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }
}
