package com.base;

public class ProductDescription {
    private int id;
    private double price;
    private String description;

    public ProductDescription(int id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public int getItemID() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
