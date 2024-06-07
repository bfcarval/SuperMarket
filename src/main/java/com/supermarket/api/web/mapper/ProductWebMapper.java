package com.supermarket.api.web.mapper;

import com.supermarket.api.model.dto.ProductDTO;
import com.supermarket.api.web.model.ProductResponse;
import static com.supermarket.api.util.MoneyUtil.moneyConverter;

public final class ProductWebMapper {

    public static ProductResponse productDTOToResponse(final ProductDTO productDTO) {
        return ProductResponse.builder()
                .productId(productDTO.getProductId())
                .harvest(productDTO.getHarvest())
                .price(moneyConverter(productDTO.getPrice()))
                .purchasedYear(productDTO.getPurchasedYear())
                .wineType(productDTO.getWineType())
                .build();
    }
}
