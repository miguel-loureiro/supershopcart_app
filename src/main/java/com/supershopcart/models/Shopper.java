package com.supershopcart.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@Entity
@Table(name = "shoppers")
public class Shopper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(unique = true)
    private String email;

    @Setter
    @Getter
    @Column(unique = false)
    private String name;

    @Getter
    private String password;

    @ManyToMany(mappedBy = "shoppers")
    private HashSet<ShopCart> shopCarts = new HashSet<>();

    public Shopper() {

        this.shopCarts = new HashSet<>();
    }

    public Shopper(String email, String name, String password) {

        this.email = email;
        this.name = name;
        this.password = password;
    }

    // Encrypt password before storing - for now it will be here, later move this to a ShopperService
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public HashSet<ShopCart> getShopCarts() {
        return shopCarts;
    }

    public void setShopCarts(HashSet<ShopCart> shopCarts) {
        this.shopCarts = shopCarts;
    }
}
