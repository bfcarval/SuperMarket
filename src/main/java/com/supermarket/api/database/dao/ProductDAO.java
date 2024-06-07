package com.supermarket.api.database.dao;

import com.supermarket.api.database.repository.ProductRepository;
import com.supermarket.api.mapper.ProductMapper;
import com.supermarket.api.model.dto.ProductDTO;
import com.supermarket.api.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public ProductDTO createProduct(final ProductDTO productDTO) {
        return ProductMapper.productEntityToDTO(
                productRepository.save(
                        ProductEntity.builder()
                                .price(productDTO.getPrice())
                                .harvest(productDTO.getHarvest())
                                .purchasedYear(productDTO.getPurchasedYear())
                                .wineType(productDTO.getWineType())
                                .productId(productDTO.getProductId())
                                .build()
                )
        );
    }
}