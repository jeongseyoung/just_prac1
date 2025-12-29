package com.example.mybatiscrudprac.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Alias("UserDto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long userId;
    private String userName;
    private String userEmail;
    private String status;
}
    