package com.supermarket.api.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class ProductResponse {

    @JsonProperty("codigo")
    private Long productId;

    @JsonProperty("tipo_vinho")
    private String wineType;

    @JsonProperty("preco")
    private String price;

    @JsonProperty("safra")
    private Long harvest;

    @JsonProperty("ano_compra")
    private Long purchasedYear;
}
