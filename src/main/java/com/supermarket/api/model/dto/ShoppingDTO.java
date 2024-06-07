package com.supermarket.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingDTO {

    @JsonProperty("codigo")
    private Long shoppingId;

    @JsonProperty("quantidade")
    private Long quantity;
}
