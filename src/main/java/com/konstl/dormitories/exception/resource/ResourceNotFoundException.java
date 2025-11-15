package com.konstl.dormitories.exception.resource;

import com.konstl.dormitories.exception.BasicException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class ResourceNotFoundException extends BasicException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(
                HttpStatus.NOT_FOUND,
                String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue)
        );
    }
}