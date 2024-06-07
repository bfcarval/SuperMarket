package com.supermarket.api.mapper;

import com.supermarket.api.feign.model.ShoppingFeignResponse;
import com.supermarket.api.model.dto.ShoppingDTO;
import com.supermarket.api.model.entity.ShoppingEntity;

public final class ShoppingMapper {

    public static ShoppingDTO shoppingEntityToDTO(final ShoppingEntity shoppingEntity) {
        return ShoppingDTO.builder()
                .shoppingId(shoppingEntity.getShoppingId())
                .productId(shoppingEntity.getProductId())
                .quantity(shoppingEntity.getQuantity())
                .build();
    }

    public static ShoppingDTO shoppingFeignResponseToDTO(final ShoppingFeignResponse shoppingFeignResponse) {
        return ShoppingDTO.builder()
                .productId(shoppingFeignResponse.getProductId())
                .quantity(shoppingFeignResponse.getQuantity())
                .build();
    }
}