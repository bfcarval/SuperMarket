package com.supermarket.api.feign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientFeignResponse {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cpf")
    private Long document;

    @JsonProperty("compras")
    private List<ShoppingFeignResponse> shopping;
}