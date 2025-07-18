package com.supershopcart.repositories;

import com.supershopcart.models.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopperRepository extends JpaRepository<Shopper, Long> {

    Optional<Shopper> findByEmail(String email);
}
