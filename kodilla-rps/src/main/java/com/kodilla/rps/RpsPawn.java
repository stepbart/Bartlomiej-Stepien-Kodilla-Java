package com.kodilla.rps;

public class RpsPawn {
    private String name;

    public void setName(int number) {
        if (number == 0) {
            this.name = "Kamień";
        }
        if (number == 1) {
            this.name = "Papier";
        }
        if (number == 2) {
            this.name = "Nożyce";
        }
    }

    public String getName() {
        return name;
    }
}
