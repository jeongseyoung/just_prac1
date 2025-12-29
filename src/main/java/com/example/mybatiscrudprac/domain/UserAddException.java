package com.example.mybatiscrudprac.domain;

import lombok.Getter;

@Getter
public class UserAddException extends RuntimeException {

    private final ErrorEnum errorEnum;

    public UserAddException(ErrorEnum e) {
        super(e.getMessage());
        this.errorEnum = e;
    }
    
}
