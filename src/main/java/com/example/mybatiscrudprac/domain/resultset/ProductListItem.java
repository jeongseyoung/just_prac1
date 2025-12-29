package com.example.mybatiscrudprac.domain.resultset;

import com.example.mybatiscrudprac.domain.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductListItem {
    
    private int productId;
    private String productName;
    private int productPrice;
    private String productOrigin;

    public ProductListItem(ProductDto dto) {
        this.productId = dto.getProductId();
        this.productName = dto.getProductName();
        this.productPrice = dto.getProductPrice();
        this.productOrigin = dto.getProductOrigin();
    }
}
