package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final String name;
    private final String peopleQuantity;

    public Country(String name, String peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    BigDecimal getPeopleQuantity() {
        return new BigDecimal(peopleQuantity);
    }
}
