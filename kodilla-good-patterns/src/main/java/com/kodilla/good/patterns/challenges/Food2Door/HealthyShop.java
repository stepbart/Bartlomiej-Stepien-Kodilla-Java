package com.kodilla.good.patterns.challenges.Food2Door;

public class HealthyShop extends Producer{

    public HealthyShop() {
        this.setConfirmNeeded(false);
        this.setHasOwnFleet(false);
        this.setName("Healthy Shop");
    }
}
