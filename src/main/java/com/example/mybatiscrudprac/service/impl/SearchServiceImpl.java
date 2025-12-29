package com.example.mybatiscrudprac.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mybatiscrudprac.domain.ErrorEnum;
import com.example.mybatiscrudprac.domain.ProductDto;
import com.example.mybatiscrudprac.domain.ProductException;
import com.example.mybatiscrudprac.domain.ProductSearchCondition;
import com.example.mybatiscrudprac.domain.UserDto;
import com.example.mybatiscrudprac.domain.pageItem.PageResponse;
import com.example.mybatiscrudprac.domain.resultset.ProductListItem;
import com.example.mybatiscrudprac.domain.resultset.UserListItem;
import com.example.mybatiscrudprac.mapper.SearchMapper;
import com.example.mybatiscrudprac.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService{
    
    private final SearchMapper searchMapper;

    @Override
    public PageResponse<UserListItem> search(
        int page, int size, String where, String keyword, String sort, String orderby, String status) {

        int offset = (page - 1) * size;
        //long totalSearchCount = searchMapper.totalSearchCount();

        List<UserDto> list = searchMapper.getSearchList(size, offset, where, keyword, sort, orderby, status);        
        List<UserListItem> result = list.stream().map(user -> new UserListItem(user)).toList();
        long totalCount = result.size();
        return PageResponse.ok(page, size, totalCount, result);
    }

    @Override
    public PageResponse<ProductListItem> search_product(ProductSearchCondition c) {

                int totalCount = searchMapper.getProductSearchToTalCount(c);

                List<ProductDto> list = searchMapper.getProductSearchList(c);
                List<ProductListItem> result = list.stream().map(item -> new ProductListItem(item)).toList();
                
                if(list.isEmpty()) throw new ProductException(ErrorEnum.EMPTY);

                return PageResponse.ok(c.getPage(), c.getSize(), totalCount, result);
    }
    
}
