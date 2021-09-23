package com.kodilla.good.patterns.challenges;

import java.util.List;

public class OrderDto {
    public User user;
    public List<Product> productList;

    public OrderDto(User user, List<Product> productList) {
        this.user = user;
        this.productList = productList;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
