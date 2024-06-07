package com.supermarket.api.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TotalShoppingDTO {

    private String clientName;
    private Long document;
    private List<ClientShoppingDTO> clientShoppingDTOS;
}
