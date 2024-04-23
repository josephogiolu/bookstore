package com.interswitchgroup.bookstore.exception;

import com.interswitchgroup.bookstore.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandlerAdvice {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ApiResponse<String>> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, HttpStatus.NOT_FOUND.toString(), e.getMessage(), null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage(), exception.getLocalizedMessage()));

    }
    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ApiResponse<String>> handleMethodArgumentNotValid(
            WebExchangeBindException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(false, HttpStatus.BAD_REQUEST.toString(), String.join(",", errors), String.join(",", errors)));
    }


}