package com.kodilla.good.patterns.challenges.Food2Door;

public interface OrderCreator {

    void process(ConfirmOperator confirmOperator, FleetOrganiser fleetOrganiser, OrderDeliveryCreator orderDeliveryCreator, Product product);
}
