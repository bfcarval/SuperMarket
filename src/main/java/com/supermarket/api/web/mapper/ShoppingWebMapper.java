package com.supermarket.api.web.mapper;

import com.supermarket.api.model.dto.ClientShoppingDTO;
import com.supermarket.api.model.dto.TotalShoppingDTO;
import com.supermarket.api.web.model.ShoppingResponse;
import com.supermarket.api.web.model.TotalShoppingResponse;
import java.util.stream.Collectors;
import static com.supermarket.api.util.MoneyUtil.moneyConverter;
import static com.supermarket.api.web.mapper.ProductWebMapper.productDTOToResponse;

public final class ShoppingWebMapper {

    public static TotalShoppingResponse shoppingDTOToResponse(final TotalShoppingDTO totalShoppingDTO) {
        return TotalShoppingResponse.builder()
                .clientName(totalShoppingDTO.getClientName())
                .document(totalShoppingDTO.getDocument())
                .shoppingResponseList(totalShoppingDTO.getClientShoppingDTOS().stream().map(ShoppingWebMapper::clientShoppingDTOToResponse).collect(Collectors.toList()))
                .build();
    }

    private static ShoppingResponse clientShoppingDTOToResponse(final ClientShoppingDTO clientShoppingDTO) {
        return ShoppingResponse.builder()
                .product(productDTOToResponse(clientShoppingDTO.getProduct()))
                .quantity(clientShoppingDTO.getQuantity())
                .total(moneyConverter(clientShoppingDTO.getTotal()))
                .build();
    }

}