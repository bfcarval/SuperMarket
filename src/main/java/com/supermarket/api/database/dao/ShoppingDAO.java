package com.supermarket.api.database.dao;

import com.supermarket.api.database.repository.ShoppingRepository;
import com.supermarket.api.mapper.ShoppingMapper;
import com.supermarket.api.model.dto.ClientDTO;
import com.supermarket.api.model.dto.ShoppingDTO;
import com.supermarket.api.model.entity.ShoppingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingDAO {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingDTO createShopping(final ShoppingDTO shoppingDTO, final ClientDTO clientDTO) {
        return ShoppingMapper.shoppingEntityToDTO(shoppingRepository.save(
                ShoppingEntity.builder()
                        .document(clientDTO.getDocument())
                        .productId(shoppingDTO.getShoppingId())
                        .quantity(shoppingDTO.getQuantity())
                        .build()
        ));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ShoppingEntity> findShoppingByIds(final List<Long> shoppingIds) {
        return new ArrayList<>(shoppingRepository.findByShoppingIds(shoppingIds));
    }
}
