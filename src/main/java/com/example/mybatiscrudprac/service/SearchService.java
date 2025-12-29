package com.example.mybatiscrudprac.service;

import com.example.mybatiscrudprac.domain.ProductSearchCondition;
import com.example.mybatiscrudprac.domain.pageItem.PageResponse;
import com.example.mybatiscrudprac.domain.resultset.ProductListItem;
import com.example.mybatiscrudprac.domain.resultset.UserListItem;

public interface SearchService {

    PageResponse<UserListItem> search(int page, int size, String where, String keyword, String sort, String orderby, String status);

    PageResponse<ProductListItem> search_product(ProductSearchCondition c);

}
