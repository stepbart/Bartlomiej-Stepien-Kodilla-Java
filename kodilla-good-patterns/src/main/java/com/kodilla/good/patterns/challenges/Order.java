package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private int orderID;
    private List<Product> productList = new ArrayList<>();
    private OrderStatus status;

    public Order(User user, int orderID, List<Product> productList, OrderStatus status) {
        this.user = user;
        this.orderID = orderID;
        this.productList = productList;
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return productList;
    }


}