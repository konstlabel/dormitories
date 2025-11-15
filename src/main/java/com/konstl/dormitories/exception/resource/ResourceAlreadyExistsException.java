package com.konstl.dormitories.exception.resource;

import com.konstl.dormitories.exception.BasicException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class ResourceAlreadyExistsException extends BasicException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistsException(String resourceName, String fieldName, Object fieldValue) {
        super(
                HttpStatus.CONFLICT,
                String.format("%s already exists with %s: '%s'", resourceName, fieldName, fieldValue)
        );
    }
}
