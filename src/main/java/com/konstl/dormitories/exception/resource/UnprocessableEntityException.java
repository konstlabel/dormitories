package com.konstl.dormitories.exception.resource;

import com.konstl.dormitories.exception.BasicException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class UnprocessableEntityException extends BasicException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UnprocessableEntityException(String message) {

        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }
}
