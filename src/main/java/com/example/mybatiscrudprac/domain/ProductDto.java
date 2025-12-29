package com.example.mybatiscrudprac.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Alias("ProductDto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int productId;
    private String productName;
    private int productPrice;
    private String productOrigin;
}
