package com.supermarket.api.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopClientResponse {

    @JsonProperty("nome_cliente")
    private String name;

    @JsonProperty("quantidade_total_compra")
    private Long quantity;

    @JsonProperty("valor_total_compra")
    private String total;
}