package com.twuc.shopping.entity;

import com.twuc.shopping.dto.ProductDto;
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

    public static ProductEntity convertProductToProductEntity(ProductDto productDto) {
        return ProductEntity.builder()
            .name(productDto.getName())
            .price(productDto.getPrice())
            .imageUrl(productDto.getImageUrl())
            .unit(productDto.getUnit())
            .build();
    }
}
