package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class RegularOrderCreator implements OrderCreator{

    @Override
    public Order createOrder(User user, List<Product> productList) {
        OrderIDReceiver orderIDReceiver = new OrderIDReceiver();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Order order = new Order(user,orderIDReceiver.getNewOrderID(user, localDate, localTime),productList,OrderStatus.RECEIVED);
        return order;
    }
}
