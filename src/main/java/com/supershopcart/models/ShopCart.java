package com.supershopcart.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ShopCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false)
    private String identifier; // Unique token like timestamp

    @Column(name = "created_at", updatable = false)
    private long createdAt;

    @ManyToMany
    @JoinTable(
            name = "shopcart_shopper",
            joinColumns = @JoinColumn(name = "shopcart_id"),
            inverseJoinColumns = @JoinColumn(name = "shopper_id")
    )
    private HashSet<Shopper> users = new HashSet<>();

    @OneToMany(mappedBy = "shopCartList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroceryItem> items = new ArrayList<>();


    public ShopCart() {
        this.createdAt = System.currentTimeMillis();
        this.identifier = "cart_" + this.createdAt;
    }
}
