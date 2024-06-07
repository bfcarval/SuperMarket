package com.supermarket.api.web.mapper;

import com.supermarket.api.model.dto.TopClientDTO;
import com.supermarket.api.web.model.TopClientResponse;
import static com.supermarket.api.util.MoneyUtil.moneyConverter;

public final class ClientWebMapper {

    public static TopClientResponse topClientDTOToResponse(final TopClientDTO topClientDTO) {
        return TopClientResponse.builder()
                .name(topClientDTO.getName())
                .quantity(topClientDTO.getQuantity())
                .total(moneyConverter(topClientDTO.getTotal()))
                .build();
    }
}
