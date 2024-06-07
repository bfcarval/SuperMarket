package com.supermarket.api.feign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingFeignResponse {

    @JsonProperty("codigo")
    private Long productId;

    @JsonProperty("quantidade")
    private Long quantity;
}
