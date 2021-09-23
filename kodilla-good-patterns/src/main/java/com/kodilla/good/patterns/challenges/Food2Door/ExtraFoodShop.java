package com.kodilla.good.patterns.challenges.Food2Door;

public class ExtraFoodShop extends Producer{

    public ExtraFoodShop() {
        this.setHasOwnFleet(true);
        this.setConfirmNeeded(false);
        this.setName("Extra Food Shop");
    }
}
