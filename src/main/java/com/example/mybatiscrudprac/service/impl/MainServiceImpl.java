package com.example.mybatiscrudprac.service.impl;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.example.mybatiscrudprac.domain.ErrorEnum;
import com.example.mybatiscrudprac.domain.UserAddException;
import com.example.mybatiscrudprac.domain.UserDto;
import com.example.mybatiscrudprac.domain.pageItem.PageResponse;
import com.example.mybatiscrudprac.domain.resultset.UserListItem;
import com.example.mybatiscrudprac.mapper.MainMapper;
import com.example.mybatiscrudprac.service.MainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{

    private final MainMapper mainMapper;

    @Override
    public void addUser(UserDto user) {
        //UserDto user_1 = new UserDto(1, "a", "a@a.com"); 
        try { 
            int result = mainMapper.userAdd(user);
            if(result == 0) {
                throw new UserAddException(ErrorEnum.USER_ADD_FAILED);
            }
            
        } catch (DuplicateKeyException e) {
            throw new UserAddException(ErrorEnum.DUPLICATED_EMAIL);
        }
    }

    @Override
    public UserDto getUser(String userName) {
        mainMapper.getUser(userName);
        return null;
    }

    @Override
    public PageResponse<UserListItem> getuserlist(int page, int size) {

        int offset = (page - 1) * size;
        long totalCount = mainMapper.getTotalCount();
        List<UserDto> temp_list = mainMapper.getuserlist(size, offset);
        List<UserListItem> list =temp_list.stream().map(dto -> new UserListItem(dto)).toList();

        return PageResponse.ok(page, size, totalCount, list);
        
    }
    
}
