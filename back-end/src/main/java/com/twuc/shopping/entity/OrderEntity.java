package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    private Integer id;

    Integer amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity product;
}
