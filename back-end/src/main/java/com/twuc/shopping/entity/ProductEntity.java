package com.twuc.shopping.entity;

import com.twuc.shopping.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private int price;
    private String unit;
    private String imageUrl;

    public static ProductEntity convertProductToProductEntity(Product product) {
        return ProductEntity.builder()
            .name(product.getName())
            .price(product.getPrice())
            .imageUrl(product.getImageUrl())
            .unit(product.getUnit())
            .build();
    }
}
