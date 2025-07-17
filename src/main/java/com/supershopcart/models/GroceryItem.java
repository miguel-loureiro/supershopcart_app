package com.supershopcart.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class GroceryItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String designation;
    @Setter
    @Getter
    private String quantity;
    private boolean purchased = false;

    // Constructors
    public GroceryItem() {}

    public GroceryItem(String designation, String quantity) {
        this.designation = designation;
        this.quantity = quantity;
        this.purchased = false;
    }

}
