package com.supermarket.api.feign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFeignResponse {

    @JsonProperty("codigo")
    private Long productId;

    @JsonProperty("tipo_vinho")
    private String wineType;

    @JsonProperty("preco")
    private BigDecimal price;

    @JsonProperty("safra")
    private Long harvest;

    @JsonProperty("ano_compra")
    private Long purchasedYear;
}