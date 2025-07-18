package com.supershopcart.models;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private HashSet<Shopper> shoppers = new HashSet<>();

    @OneToMany(mappedBy = "shopCartList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroceryItem> items = new ArrayList<>();


    public ShopCart() {
        this.createdAt = System.currentTimeMillis();
        this.identifier = "cart_" + this.createdAt;
    }

    /**
     * Returns a short date key in ddMMyyyy format (for filtering).
     */
    @Transient
    public String getDateKeyForQuery() {
        SimpleDateFormat dateOnly = new SimpleDateFormat("ddMMyyyy");
        return dateOnly.format(new Date(this.createdAt));
    }

    /**
     * This method will generate a String that represents the date in a specific format (ddMMyyyy) for helping queries
     * @param millis
     * @return String with the format ddMMyyyy from the parameter millis
     */
    private String generateDateTimeIdentifier(long millis) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return formatter.format(new Date(millis));
    }

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

    public HashSet<Shopper> getShoppers() {
        return shoppers;
    }

    public void setShoppers(HashSet<Shopper> shoppers) {
        this.shoppers = shoppers;
    }

    public List<GroceryItem> getItems() {
        return items;
    }

    public void setItems(List<GroceryItem> items) {
        this.items = items;
    }
}
