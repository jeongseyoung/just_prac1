package com.example.mybatiscrudprac.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mybatiscrudprac.domain.ProductSearchCondition;
import com.example.mybatiscrudprac.domain.pageItem.PageResponse;
import com.example.mybatiscrudprac.domain.resultset.ProductListItem;
import com.example.mybatiscrudprac.domain.resultset.UserListItem;
import com.example.mybatiscrudprac.service.SearchService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/users")
    public ResponseEntity<PageResponse<UserListItem>> getMethodName(
        @RequestParam(value = "pg", required = false, defaultValue = "1") int page, 
        @RequestParam(value = "sz", required = false, defaultValue = "5") int size, 
        @RequestParam(value = "wh", required = true, defaultValue = "userName") String where,
        @RequestParam(value = "kw", required = true) String keyword,
        @RequestParam(value = "s", required = false, defaultValue = "id") String sort,
        @RequestParam(value = "ob", required = false, defaultValue = "DESC") String orderby,
        @RequestParam(value = "sta", required = false, defaultValue = "active") String status) {
        
            System.out.println(page + " " + size + " " + where + " " + keyword + " " + sort + " " + orderby + " " + status);
            
        return ResponseEntity.ok(searchService.search(page, size, where, keyword, sort, orderby, status));
    }

    //http://localhost:8098/product/search?page=1&size=3&keyword=samsung&searchPrice=500&priceConditionEnum=MORE
    @GetMapping("/product/search")
    public ResponseEntity<PageResponse<ProductListItem>> searchProduct(ProductSearchCondition c) {

        return ResponseEntity.ok(searchService.search_product(c));

    }

    @Operation(summary = "post방식 상품검색",
            description = "검색어, 원산지, 가격으로 검색"
    )
    @PostMapping("/product/searchp")
    public ResponseEntity<PageResponse<ProductListItem>> postSearchProduct(@RequestBody ProductSearchCondition c) {
        log.info("c: {} {} {} {} {}", c.getPage(), c.getSize(), c.getKeyword(), c.getProductOrigin());
        return ResponseEntity.ok(searchService.search_product(c));
        //return null;
    }
    
    
}
