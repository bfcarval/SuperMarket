package com.supermarket.api.database.repository;

import com.supermarket.api.model.entity.ShoppingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingRepository extends JpaRepository<ShoppingEntity, Long> {

    @Query("Select s from ShoppingEntity s where shoppingId in :ids")
    List<ShoppingEntity> findByShoppingIds(@Param("ids") final List<Long> ids);
}
