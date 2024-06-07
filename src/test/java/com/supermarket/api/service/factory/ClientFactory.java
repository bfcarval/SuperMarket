package com.supermarket.api.service.factory;

import com.supermarket.api.model.dto.ClientDTO;
import com.supermarket.api.model.dto.ShoppingDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ClientFactory {

    public static List<ClientDTO> makeClients() {
        return Arrays.asList(
                ClientDTO.builder()
                        .name("User 1")
                        .document(123L)
                        .shoppingDTOList(Collections.singletonList(
                                ShoppingDTO.builder()
                                        .shoppingId(1L)
                                        .productId(1L)
                                        .quantity(4L)
                                        .build()
                        ))
                        .build(),

                ClientDTO.builder()
                        .name("User 2")
                        .document(1236L)
                        .shoppingDTOList(Collections.singletonList(
                                ShoppingDTO.builder()
                                        .shoppingId(2L)
                                        .productId(2L)
                                        .quantity(5L)
                                        .build()
                        )).build(),

                ClientDTO.builder()
                        .name("User 3")
                        .document(1237L)
                        .shoppingDTOList(Collections.singletonList(
                                ShoppingDTO.builder()
                                        .shoppingId(2L)
                                        .productId(2L)
                                        .quantity(6L)
                                        .build()
                        )).build()
        );
    }
}
