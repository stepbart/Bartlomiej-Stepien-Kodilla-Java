package com.kodilla.good.patterns.challenges.Food2Door;

public class Producer implements OrderCreator {

    private String name;
    private boolean hasOwnFleet;
    private boolean isConfirmNeeded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasOwnFleet() {
        return hasOwnFleet;
    }

    public void setHasOwnFleet(boolean hasOwnFleet) {
        this.hasOwnFleet = hasOwnFleet;
    }

    public boolean isConfirmNeeded() {
        return isConfirmNeeded;
    }

    public void setConfirmNeeded(boolean confirmNeeded) {
        isConfirmNeeded = confirmNeeded;
    }

    public void process(ConfirmOperator confirmOperator, FleetOrganiser fleetOrganiser, OrderDeliveryCreator orderDeliveryCreator, Product product) {

        if (this.isConfirmNeeded() == false) {

            if (this.isHasOwnFleet() == false) {
                fleetOrganiser.arrangeTransportation(this);
            } else {
                orderDeliveryCreator.sendOrder(this, product);
            }
        } else {
            if (this.isHasOwnFleet() == false) {
                if (confirmOperator.confirm(this)) {
                    fleetOrganiser.arrangeTransportation(this);
                }
            } else {
                if (confirmOperator.confirm(this)) {
                    orderDeliveryCreator.sendOrder(this, product);
                }
            }

        }


    }
}
