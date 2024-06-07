package com.supermarket.api.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class TotalShoppingResponse {

    @JsonProperty("nome_cliente")
    private String clientName;

    @JsonProperty("cpf")
    private Long document;

    @JsonProperty("compras")
    private List<ShoppingResponse> shoppingResponseList;
}