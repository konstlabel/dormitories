package com.konstl.dormitories.utils;

import com.konstl.dormitories.exception.BasicException;
import org.springframework.http.HttpStatus;

public class PageUtil {

    public static final int MAX_PAGE_SIZE = 30;

    public static void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BasicException(HttpStatus.BAD_REQUEST, "Page number cannot be less than zero.");
        }

        if (size < 0) {
            throw new BasicException(HttpStatus.BAD_REQUEST, "Size number cannot be less than zero.");
        }

        if (size > MAX_PAGE_SIZE) {
            throw new BasicException(HttpStatus.BAD_REQUEST, "Page size must not be greater than " + MAX_PAGE_SIZE);
        }
    }
}
