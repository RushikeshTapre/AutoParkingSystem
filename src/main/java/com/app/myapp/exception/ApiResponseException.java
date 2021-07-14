package com.app.myapp.exception;

import com.app.myapp.pojo.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiResponseException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(request.toString());
        return handleExceptionInternal(ex, errorMessage(HttpStatus.BAD_REQUEST, ex, request), headers, HttpStatus.BAD_REQUEST, request);
    }

    private ApiResponse errorMessage(HttpStatus httpStatus, Exception ex, WebRequest request) {
        final String message = ex.getMessage() == null ? ex.getClass().getName() : ex.getMessage();
        final String developerMessage = ex.getCause() == null ? ex.toString() : ex.getCause().getMessage();
        return new ApiResponse(true, message, LocalDateTime.now());
    }

}