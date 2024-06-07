package com.supermarket.api.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ShoppingResponse {

    @JsonProperty("produto")
    private ProductResponse product;

    @JsonProperty("quantidade_compra")
    private Long quantity;

    @JsonProperty("valor_total_compra")
    private String total;
}
