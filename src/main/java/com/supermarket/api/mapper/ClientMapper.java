package com.supermarket.api.mapper;

import com.supermarket.api.feign.model.ClientFeignResponse;
import com.supermarket.api.feign.model.ShoppingFeignResponse;
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
                .shoppingDTOList(shoppingEntityList.stream().map(ShoppingMapper::shoppingEntityToDTO).collect(Collectors.toList()))
                .build();
    }

    public static ClientDTO clientFeignResponseToDTO(final ClientFeignResponse clientFeignResponse) {
        return ClientDTO.builder()
                .document(clientFeignResponse.getDocument())
                .name(clientFeignResponse.getName())
                .build();
    }
}
