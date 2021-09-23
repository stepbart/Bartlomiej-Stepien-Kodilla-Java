package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private OrderCreator orderCreator;
    private OrderNotifier orderNotifier;

    public OrderProcessor(final OrderCreator orderCreator,final OrderNotifier orderNotifier) {
        this.orderCreator = orderCreator;
        this.orderNotifier = orderNotifier;
    }

    public OrderDto process(final Order order) {
        OrderDto orderDto = new OrderDto(order.getUser(), order.getProductList());
        return orderDto;
        }
}

