package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Russia", "142470272"));
        europe.addCountry(new Country("Turkey", "84786000"));
        europe.addCountry(new Country("Germany", "83914472"));
        europe.addCountry(new Country("United Kingdom", "68060502"));
        europe.addCountry(new Country("France", "65343775"));

        Continent africa = new Continent("Africa");
        africa.addCountry(new Country("Nigeria", "195874685"));
        africa.addCountry(new Country("Ethiopia", "109224414"));
        africa.addCountry(new Country("Egypt", "98423598"));
        africa.addCountry(new Country("Congo", "84068091"));
        africa.addCountry(new Country("South Africa", "57792518"));

        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("China", "1427647786"));
        asia.addCountry(new Country("India", "1352642280"));
        asia.addCountry(new Country("Indonesia", "267670543"));
        asia.addCountry(new Country("Pakistan", "212228286"));
        asia.addCountry(new Country("Bangladesh", "161376708"));

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(new Country("United States", "332605398"));
        northAmerica.addCountry(new Country("Mexico", "130060167"));
        northAmerica.addCountry(new Country("Canada", "35151728"));
        northAmerica.addCountry(new Country("Guatemala", "18195184"));
        northAmerica.addCountry(new Country("Haiti", "11518548"));

        Continent southAmerica = new Continent("South America");
        southAmerica.addCountry(new Country("Brazil", "209469323"));
        southAmerica.addCountry(new Country("Colombia", "49661048"));
        southAmerica.addCountry(new Country("Argentina", "44361150"));
        southAmerica.addCountry(new Country("Peru", "31989260"));
        southAmerica.addCountry(new Country("Venezuela", "28887118"));

        Continent australia = new Continent("Australia");
        australia.addCountry(new Country("Australia", "25832000"));
        australia.addCountry(new Country("Papua New Guinea", "8935000"));

        Continent antarctica = new Continent("Antarctica");
        antarctica.addCountry(new Country("Antarctica", "4400"));

        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);
        world.addContinent(australia);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(antarctica);

        //When
        BigDecimal totalPopulation = world.getPeopleQuantity(world);
        long numberOfCountries = world.getContinents().stream()
                .flatMap(continent -> continent.getCountries().stream())
                .count();

        //Then
        BigDecimal expectedValue = new BigDecimal("5338194254");
        assertEquals(expectedValue, totalPopulation);
        assertEquals(28, numberOfCountries);
    }
}