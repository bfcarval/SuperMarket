package com.supermarket.api.mapper;

import com.supermarket.api.feign.model.ProductFeignResponse;
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

    public static ProductDTO productFeignResponseToDTO(final ProductFeignResponse productFeignResponse) {
        return ProductDTO.builder()
                .productId(productFeignResponse.getProductId())
                .price(productFeignResponse.getPrice())
                .harvest(productFeignResponse.getHarvest())
                .purchasedYear(productFeignResponse.getPurchasedYear())
                .wineType(productFeignResponse.getWineType())
                .build();
    }
}