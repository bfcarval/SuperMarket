package com.supermarket.api.model.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClientShoppingDTO {

    private ProductDTO product;
    private Long quantity;
    private BigDecimal total;
}
