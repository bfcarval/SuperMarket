package com.supermarket.api.mapper;

import com.supermarket.api.model.dto.ShoppingDTO;
import com.supermarket.api.model.entity.ShoppingEntity;

public final class ShoppingMapper {

    public static ShoppingDTO shoppingEntityToDTO(final ShoppingEntity shoppingEntity) {
        return ShoppingDTO.builder()
                .shoppingId(shoppingEntity.getShoppingId())
                .quantity(shoppingEntity.getQuantity())
                .build();
    }
}