package com.example.mybatiscrudprac.domain;

import lombok.Getter;

@Getter
public class ProductException extends RuntimeException{
    
    private final ErrorEnum errorEnum;

    public ProductException(ErrorEnum e) {
        super(e.getMessage());
        this.errorEnum = e;
    }
}
