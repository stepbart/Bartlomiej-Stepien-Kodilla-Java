package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderProcessor {
    private ConfirmOperator confirmOperator;
    private FleetOrganiser fleetOrganiser;
    private OrderDeliveryCreator orderDeliveryCreator;

    public OrderProcessor(ConfirmOperator confirmOperator, FleetOrganiser fleetOrganiser, OrderDeliveryCreator orderDeliveryCreator) {
        this.confirmOperator = confirmOperator;
        this.fleetOrganiser = fleetOrganiser;
        this.orderDeliveryCreator = orderDeliveryCreator;
    }


}
