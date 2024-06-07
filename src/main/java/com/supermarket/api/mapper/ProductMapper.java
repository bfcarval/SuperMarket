package com.supermarket.api.mapper;

import com.supermarket.api.model.dto.ProductDTO;
import com.supermarket.api.model.entity.ProductEntity;

public final class ProductMapper {

    public static ProductDTO productEntityToDTO(final ProductEntity productEntity) {
        return ProductDTO.builder()
                .productId(productEntity.getProductId())
                .price(productEntity.getPrice())
                .harvest(productEntity.getHarvest())
                .purchasedYear(productEntity.getPurchasedYear())
                .wineType(productEntity.getWineType())
                .build();
    }
}