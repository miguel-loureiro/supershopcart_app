package com.supershopcart.models;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

@Entity
public class ShopCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false)
    private String identifier; // Unique token like timestamp

    @Column(name = "created_at", updatable = false)
    private long createdAt;

    @OneToMany(mappedBy = "shopCartList", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GroceryItem> items = new HashSet<>();

    public ShopCart() {
        this.createdAt = System.currentTimeMillis();
        this.identifier = "cart_" + this.createdAt;
    }

    @Transient
    public String getDateKeyForQuery() {
        SimpleDateFormat dateOnly = new SimpleDateFormat("ddMMyyyy");
        dateOnly.setTimeZone(TimeZone.getDefault());
        return dateOnly.format(new Date(this.createdAt));
    }

    private String generateDateTimeIdentifier(long millis) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return formatter.format(new Date(millis));
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public Set<GroceryItem> getItems() {
        return items;
    }

    public void setItems(Set<GroceryItem> items) {
        this.items = items;
    }
}
