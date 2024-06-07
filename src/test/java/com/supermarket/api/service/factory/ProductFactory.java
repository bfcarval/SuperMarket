package com.supermarket.api.service.factory;

import com.supermarket.api.model.entity.ProductEntity;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class ProductFactory {

    public static List<ProductEntity> makeProducts() {
        return Arrays.asList(
                ProductEntity.builder()
                        .productId(1L)
                        .wineType("Tinto")
                        .price(BigDecimal.valueOf(50.00))
                        .harvest(2017L)
                        .purchasedYear(2018L)
                        .build(),

                ProductEntity.builder()
                        .productId(2L)
                        .wineType("Seco")
                        .price(BigDecimal.valueOf(100.00))
                        .harvest(2017L)
                        .purchasedYear(2019L)
                        .build()
        );
    }
}
