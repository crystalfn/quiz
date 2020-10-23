package com.twuc.shopping.utils;

import com.twuc.shopping.dto.ProductDto;

public class ProductUtil {
    public static ProductDto creatProduct() {
        return ProductDto.builder()
            .name("可乐")
            .price(3)
            .imageUrl("https://gd4.alicdn.com/imgextra/i2/1954271860/O1CN016e5eLI1PbvGO8EpRR_!!1954271860.jpg_400x400.jpg")
            .unit("瓶")
            .build();
    }
}
