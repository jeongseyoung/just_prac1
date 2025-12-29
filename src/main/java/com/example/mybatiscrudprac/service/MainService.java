package com.example.mybatiscrudprac.service;




import com.example.mybatiscrudprac.domain.UserDto;
import com.example.mybatiscrudprac.domain.pageItem.PageResponse;
import com.example.mybatiscrudprac.domain.resultset.UserListItem;

public interface MainService {

    void addUser(UserDto user);

    UserDto getUser(String userName);

    PageResponse<UserListItem> getuserlist(int page, int size);
}
