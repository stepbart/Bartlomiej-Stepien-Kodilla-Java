package com.kodilla.good.patterns.challenges;

public class StatusController implements StatusUpdater{

    @Override
    public void updateStatus(Order order, OrderStatus orderStatus) {
        order.setStatus(orderStatus);
    }
}
