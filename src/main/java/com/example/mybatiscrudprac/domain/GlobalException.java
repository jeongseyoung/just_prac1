package com.example.mybatiscrudprac.domain;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.mybatiscrudprac.domain.res.ErrorResponse;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserAddException.class)
    public ResponseEntity<ErrorResponse> handlerUserCreate(UserAddException e) {
        return ResponseEntity.status(e.getErrorEnum().getHttpStatus())
        .body(new ErrorResponse(false, e.getErrorEnum().getMessage(), LocalDateTime.now(), "/users"));
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handlerProduct(ProductException e) {
        return ResponseEntity.status(e.getErrorEnum().getHttpStatus())
        .body(new ErrorResponse(false, e.getMessage(), LocalDateTime.now(), "/product/searchp"));
    }
}
