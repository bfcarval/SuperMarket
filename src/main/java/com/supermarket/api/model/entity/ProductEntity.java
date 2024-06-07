package com.supermarket.api.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "wine_type")
    private String wineType;

    @Column(precision = 11, scale = 2)
    private BigDecimal price;

    @Column
    private Long harvest;

    @Column(name = "purchased_year")
    private Long purchasedYear;
}