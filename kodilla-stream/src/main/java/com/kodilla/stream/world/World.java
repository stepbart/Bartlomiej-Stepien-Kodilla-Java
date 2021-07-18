package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> continents = new ArrayList<>();

    public List<Continent> getContinents() {
        return continents;
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public static void main(String[] args) {

        Continent europe = new Continent("Europe");
        Country country1 = new Country("Russia", "142470272");
        europe.addCountry(country1);
    }

    public BigDecimal getPeopleQuantity(World world) {

        BigDecimal peopleQuantity = world.getContinents().stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return peopleQuantity;
    }
}
