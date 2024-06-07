package com.supermarket.api.mapper;

import com.supermarket.api.model.dto.ClientDTO;
import com.supermarket.api.model.entity.ClientEntity;
import com.supermarket.api.model.entity.ShoppingEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class ClientMapper {

    public static ClientDTO clientEntityToDTO(final ClientEntity clientEntity, final List<ShoppingEntity> shoppingEntityList) {
        return ClientDTO.builder()
                .document(clientEntity.getDocument())
                .name(clientEntity.getName())
                .shopping(shoppingEntityList.stream().map(ShoppingMapper::shoppingEntityToDTO).collect(Collectors.toList()))
                .build();
    }
}
