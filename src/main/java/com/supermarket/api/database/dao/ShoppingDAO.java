package com.supermarket.api.database.dao;

import com.supermarket.api.database.repository.ShoppingRepository;
import com.supermarket.api.model.dto.ClientDTO;
import com.supermarket.api.model.dto.ShoppingDTO;
import com.supermarket.api.model.entity.ShoppingEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ShoppingDAO {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingEntity create(final ShoppingDTO shoppingDTO, final ClientDTO clientDTO) {
        return shoppingRepository.save(
                ShoppingEntity.builder()
                        .document(clientDTO.getDocument())
                        .productId(shoppingDTO.getProductId())
                        .quantity(shoppingDTO.getQuantity())
                        .build()
        );
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ShoppingEntity> findByShoppingIds(final List<Long> shoppingIds) {
        return shoppingRepository.findByShoppingIds(shoppingIds);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ShoppingEntity> findAll() {
        return shoppingRepository.findAll();
    }
}
