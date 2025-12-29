package com.example.mybatiscrudprac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mybatiscrudprac.domain.ProductDto;
import com.example.mybatiscrudprac.domain.ProductSearchCondition;
import com.example.mybatiscrudprac.domain.UserDto;

@Mapper
public interface SearchMapper {
    List<UserDto> getSearchList(
        @Param("size") int size,
        @Param("offset") int offset,
        @Param("wh") String where,
        @Param("keyword") String keyword,
        @Param("sort") String sort,
        @Param("orderby") String orderby,
        @Param("status") String status
    ); //int page, int size, String where, String keyword, String sort, String orderby, String status

    long totalSearchCount();

    List<ProductDto> getProductSearchList(ProductSearchCondition c);

    int getProductSearchToTalCount(ProductSearchCondition c);
}
