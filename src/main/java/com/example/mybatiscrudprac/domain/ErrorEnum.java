package com.example.mybatiscrudprac.domain;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    USER_ADD_FAILED(HttpStatus.BAD_REQUEST, "등록 실패"),
    DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "email중복"),
    GET_USERLIST_FALIED(HttpStatus.BAD_REQUEST, "그냥 실패"),
    EMPTY(HttpStatus.NOT_FOUND, "empty!!");
    

    private final HttpStatus httpStatus;
    private final String message;
}
