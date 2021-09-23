package com.kodilla.good.patterns.challenges.Food2Door;

public class GlutenFreeShop extends Producer{

    public GlutenFreeShop() {
        this.setConfirmNeeded(true);
        this.setHasOwnFleet(true);
        this.setName("Gluten Free Shop");
    }
}


