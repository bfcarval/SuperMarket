package com.supermarket.api.database.repository;

import com.supermarket.api.model.entity.ProductEntity;
import com.supermarket.api.model.entity.ShoppingEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("Select p from ProductEntity p where purchasedYear = :year")
    List<ProductEntity> findByPurchasedYear(@Param("year") final Long year);
}
