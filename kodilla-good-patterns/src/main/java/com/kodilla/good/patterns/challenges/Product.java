package com.kodilla.good.patterns.challenges;

public class Product {
    private int productID;
    private double price;
    private boolean isAvailable;

    public Product(int productID, double price, boolean isAvailable) {
        this.productID = productID;
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
