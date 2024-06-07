package com.supermarket.api.database.dao;

import com.supermarket.api.database.repository.ProductRepository;
import com.supermarket.api.model.dto.ProductDTO;
import com.supermarket.api.model.entity.ProductEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(final ProductDTO productDTO) {
        productRepository.save(
                ProductEntity.builder()
                        .price(productDTO.getPrice())
                        .harvest(productDTO.getHarvest())
                        .purchasedYear(productDTO.getPurchasedYear())
                        .wineType(productDTO.getWineType())
                        .productId(productDTO.getProductId())
                        .build()
        );
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ProductEntity> findByPurchasedYear(final Long year) {
        return productRepository.findByPurchasedYear(year);
    }
}