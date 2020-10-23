package com.twuc.shopping.dto;

import com.twuc.shopping.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
    private String unit;
    private String imageUrl;

    public static Product convertProductEntityToProduct(ProductEntity productEntity) {
        return Product.builder()
            .id(productEntity.getId())
            .name(productEntity.getName())
            .price(productEntity.getPrice())
            .unit(productEntity.getUnit())
            .imageUrl(productEntity.getImageUrl())
            .build();
    }
}
