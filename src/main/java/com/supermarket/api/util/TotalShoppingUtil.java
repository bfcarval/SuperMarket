package com.supermarket.api.util;

import com.supermarket.api.model.dto.ClientDTO;
import com.supermarket.api.model.dto.ClientShoppingDTO;
import com.supermarket.api.model.dto.ProductDTO;
import com.supermarket.api.model.dto.TotalShoppingDTO;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class TotalShoppingUtil {

    public static List<TotalShoppingDTO> generateTotalShopping(final List<ClientDTO> clients, final List<ProductDTO> products) {
        return clients.stream().map(clientDTO -> {
            return TotalShoppingDTO.builder()
                    .clientName(clientDTO.getName())
                    .document(clientDTO.getDocument())
                    .clientShoppingDTOS(

                            products.stream().filter(p -> {
                                final var shopping = clientDTO.getShoppingDTOList()
                                        .stream().filter(pp -> Objects.equals(pp.getProductId(), p.getProductId()))
                                        .findFirst();

                                return shopping.filter(shoppingDTO ->
                                        Objects.equals(p.getProductId(), shoppingDTO.getProductId())).isPresent();

                            }).collect(Collectors.toList()).stream().map( productDTO -> {

                                final var shopping = clientDTO.getShoppingDTOList().stream().filter(pp -> Objects.equals(pp.getProductId(), productDTO.getProductId())).findFirst();

                                if (shopping.isPresent()) {
                                    return ClientShoppingDTO.builder()
                                            .product(productDTO)
                                            .quantity(shopping.get().getQuantity())
                                            .total(productDTO.getPrice().multiply(BigDecimal.valueOf(shopping.get().getQuantity()), MathContext.DECIMAL64))
                                            .build();
                                } else {
                                    return ClientShoppingDTO.builder().build();
                                }
                            }).collect(Collectors.toList())
                    )
                    .build();
        }).collect(Collectors.toList());
    }
}
