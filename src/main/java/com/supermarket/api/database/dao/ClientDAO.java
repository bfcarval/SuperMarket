package com.supermarket.api.database.dao;

import com.supermarket.api.database.repository.ClientRepository;
import com.supermarket.api.mapper.ClientMapper;
import com.supermarket.api.model.dto.ClientDTO;
import com.supermarket.api.model.dto.ShoppingDTO;
import com.supermarket.api.model.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientDAO {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ShoppingDAO shoppingDAO;

    @Transactional(propagation = Propagation.REQUIRED)
    public ClientDTO createClient(final ClientDTO clientDTO, final List<ShoppingDTO> shoppingDTOList) {
        final var shopping = shoppingDAO.findShoppingByIds(
                shoppingDTOList.stream().map(ShoppingDTO::getShoppingId).collect(Collectors.toList()));

        return ClientMapper.clientEntityToDTO(clientRepository.save(
                ClientEntity.builder()
                        .name(clientDTO.getName())
                        .document(clientDTO.getDocument())
                        .build()
        ), shopping);
    }
}
