package com.supermarket.api.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "shopping")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingEntity {

    @Id
    @Column(name = "shopping_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingId;

    @Column(name = "product_id")
    private Long productId;

    @Column
    private Long document;

    @Column
    private Long quantity;
}
