package com.twuc.shopping.utils;

import com.twuc.shopping.dto.Product;

public class ProductUtil {
    public static Product creatProduct() {
        return Product.builder()
            .name("可乐")
            .price(3)
            .imageUrl("url")
            .unit("瓶")
            .build();
    }
}
