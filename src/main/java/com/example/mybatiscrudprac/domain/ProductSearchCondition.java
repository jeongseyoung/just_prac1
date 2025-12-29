package com.example.mybatiscrudprac.domain;

import com.example.mybatiscrudprac.domain.enumstore.OrderByType;
import com.example.mybatiscrudprac.domain.enumstore.PriceConditionEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchCondition {

    @Schema(description = "페이지 번호 1부터 시작")
    @Min(1)
    private int page;
    @Schema(description = "페이지 번호 최대 10")
    @Max(10)
    private int size;

    @Schema(description = "검색어", example = "samsung")
    private String keyword; // 검색어
    @Schema(description = "찾을 가격")
    private int searchPrice;//
    @Schema(description = "MORE <=, LESS >=, EQUAL = ")  
    private PriceConditionEnum priceConditionEnum; // >=, <=, =
    @Schema(description = "원산지", example = "korea")
    private String productOrigin; 

    @Schema(description = "정렬방식 ASC, DESC")
    private OrderByType orderByType;

    public int getOffset() {
        return (page - 1) * size;
    }

}
