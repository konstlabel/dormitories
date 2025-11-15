package com.konstl.dormitories.exception;

import com.konstl.dormitories.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class RestControllerExceptionHandler {

    /** ALL BUSINESS-LOGIC EXCEPTIONS **/
    @ExceptionHandler(BasicException.class)
    public ResponseEntity<ApiResponse> handleBusinessException(BasicException ex) {

        ApiResponse response = new ApiResponse(false, ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    /** SPRING **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidation(MethodArgumentNotValidException ex) {

        List<String> messages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + " - " + err.getDefaultMessage())
                .toList();

        ExceptionResponse response = new ExceptionResponse(
                messages,
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {

        String message = "Parameter '" + ex.getParameter().getParameterName() +
                "' must be '" + Objects.requireNonNull(ex.getRequiredType()).getSimpleName() + "'";

        ExceptionResponse response = new ExceptionResponse(
                List.of(message),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /** HTTP **/
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {

        String message = "Request method '" + ex.getMethod() +
                "' not supported. Supported: " + ex.getSupportedHttpMethods();

        ExceptionResponse response = new ExceptionResponse(
                List.of(message),
                HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),
                HttpStatus.METHOD_NOT_ALLOWED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleJsonError(HttpMessageNotReadableException ex) {

        ExceptionResponse response = new ExceptionResponse(
                List.of("Please provide Request Body in valid JSON format"),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}