package com.supermarket.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cpf")
    private Long document;

    @JsonProperty("compras")
    private List<ShoppingDTO> shopping;
}