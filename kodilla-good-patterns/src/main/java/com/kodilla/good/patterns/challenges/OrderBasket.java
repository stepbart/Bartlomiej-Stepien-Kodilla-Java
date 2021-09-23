package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class OrderBasket implements OrdersCollector{
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void collect(Order order,Product product) {
    }
}
