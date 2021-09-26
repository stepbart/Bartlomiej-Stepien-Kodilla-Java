package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airports {
    private int numberOfAirports = 0;
    private List<Airport> airportList = new ArrayList<>();

    public void addAirport(String name){
        Airport airport = new Airport();
        airport.name = name;
        airport.number = numberOfAirports;
        airportList.add(airport);
        numberOfAirports++;
    }

    public int getNumberOfAirports() {
        return numberOfAirports;
    }

    public boolean containsAirport(String name){
        boolean contains = false;
        for (Airport a : airportList){
            if (a.name.equals(name)){
                contains = true;
            }
        }
        return contains;
    }

    public Airport getAirport(String name){
        Airport airport = new Airport();
        if (containsAirport(name)){
            for (Airport a : airportList){
                if (a.name.equals(name)){
                    airport = a;
                }
            }
        }
        else {
            airport = null;
        }
        return airport;
    }
}
