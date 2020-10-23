package com.twuc.shopping.utils;

import com.twuc.shopping.entity.ProductEntity;

public class EntityUtil {
    public static ProductEntity createProductEntity() {
        return ProductEntity.builder()
            .name("可乐")
            .price(3)
            .unit("瓶")
            .imageUrl("https://gd4.alicdn.com/imgextra/i2/1954271860/O1CN016e5eLI1PbvGO8EpRR_!!1954271860.jpg_400x400.jpg")
            .build();
    }
}
