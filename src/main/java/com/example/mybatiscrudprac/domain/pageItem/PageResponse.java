package com.example.mybatiscrudprac.domain.pageItem;

import java.util.List;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "페이지 응답")
public class PageResponse<T> {

    private int page;
    private int size;
    private long totalCount;
    private int totalPage;
    private List<T> list;
    
    public static <T> PageResponse<T> ok(int page, int size, long totalCount, List<T> list) {
        int totalPage = (int) Math.ceil((double) totalCount / size);
        return new PageResponse<>(
            page, 
            size, 
            totalCount, 
            totalPage, 
            list);
    }
}
