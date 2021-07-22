package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearching {

    public boolean findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("New York", true);
        flightMap.put("Berlin", true);
        flightMap.put("Paris", true);
        flightMap.put("London", true);
        flightMap.put("Szczecin", false);

        boolean isArrivalAirport;
        boolean isDepartureAirport;

        try {
            isArrivalAirport = flightMap.get(flight.getArrivalAirport());
            isDepartureAirport = flightMap.get(flight.getDepartureAirport());
        } catch (NullPointerException npe) {
            throw new RouteNotFoundException();
        }

        return (isArrivalAirport && isDepartureAirport);
    }
}
