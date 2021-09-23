package com.kodilla.good.patterns.challenges;

import java.util.List;

public class OrderService {

    public static void main(String[] args) {
        User sampleUser = new User("Romek99",54897);
        OrderBasket newBasket = new OrderBasket();

        OrderCreator newOrder = new RegularOrderCreator();
        OrderNotifier mailSender = new MailService();

        OrderProcessor orderProcessor = new OrderProcessor(newOrder,mailSender);
        orderProcessor.process(newOrder.createOrder(sampleUser,newBasket.getProductList()));

    }
}
