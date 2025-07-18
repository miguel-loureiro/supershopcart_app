package com.supershopcart.repositories;

import com.supershopcart.models.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopCartRepository extends JpaRepository<ShopCart, Long> {

    List<ShopCart> findAllByOrderByCreatedAtDesc();
}
