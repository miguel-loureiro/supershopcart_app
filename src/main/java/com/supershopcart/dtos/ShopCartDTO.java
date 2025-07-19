package com.supershopcart.dtos;


/**
 * Apply the DTO pattern to expose only the necessary ShopCart fields in your API, especially the identifier for filtering.
 */
public class ShopCartDTO {

    private String identifier;
    private String dateKey;

    public ShopCartDTO(String identifier, String dateKey) {
        this.identifier = identifier;
        this.dateKey = dateKey;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDateKey() {
        return dateKey;
    }

    public void setDateKey(String dateKey) {
        this.dateKey = dateKey;
    }
}
