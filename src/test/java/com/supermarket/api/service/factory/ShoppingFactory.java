package com.supermarket.api.service.factory;

import com.supermarket.api.model.entity.ShoppingEntity;
import java.util.Arrays;
import java.util.List;

public final class ShoppingFactory {

    public static List<ShoppingEntity> makeShoppings() {
        return Arrays.asList(
                ShoppingEntity.builder()
                        .shoppingId(1L)
                        .productId(1L)
                        .quantity(4L)
                        .document(123L)
                        .build(),

                ShoppingEntity.builder()
                        .shoppingId(2L)
                        .productId(2L)
                        .quantity(5L)
                        .document(1236L)
                        .build()
        );
    }
}
