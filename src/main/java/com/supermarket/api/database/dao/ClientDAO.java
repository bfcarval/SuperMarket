package com.supermarket.api.database.dao;

import com.supermarket.api.database.repository.ClientRepository;
import com.supermarket.api.mapper.ClientMapper;
import com.supermarket.api.model.dto.ClientDTO;
import com.supermarket.api.model.dto.ShoppingDTO;
import com.supermarket.api.model.entity.ClientEntity;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static com.supermarket.api.mapper.ClientMapper.clientEntityToDTO;

@Component
public class ClientDAO {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ShoppingDAO shoppingDAO;

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(final ClientDTO clientDTO) {
        clientRepository.save(
                ClientEntity.builder()
                        .name(clientDTO.getName())
                        .document(clientDTO.getDocument())
                        .build()
        );
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ClientDTO> findAll() {
        final var shopping = shoppingDAO.findAll();
        final var clients = clientRepository.findAll();

        return clients.stream().map(
                c -> clientEntityToDTO(c, shopping.stream().filter(s -> Objects.equals(s.getDocument(), c.getDocument()))
                        .collect(Collectors.toList()))).collect(Collectors.toList());
    }
}
