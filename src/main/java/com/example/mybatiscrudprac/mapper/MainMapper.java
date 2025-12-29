package com.example.mybatiscrudprac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mybatiscrudprac.domain.UserDto;

@Mapper
public interface MainMapper {
    
    //add
    int userAdd(@Param("user") UserDto user);

    UserDto getUser(String userName);

    List<UserDto> getuserlist(
        @Param("size") int size, 
        @Param("offset") int offset);
    
    long getTotalCount();
}