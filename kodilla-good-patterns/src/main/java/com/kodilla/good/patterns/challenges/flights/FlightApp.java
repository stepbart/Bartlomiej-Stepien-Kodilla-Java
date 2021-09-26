package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.good.patterns.challenges.flights.Constants.*;
import static com.kodilla.good.patterns.challenges.flights.FlightService.*;

public class FlightApp {

    public static void main(String[] args) {

        Airports airports = FlightDataReceiver.createAirportsList();
        FlightsList flightsList = FlightDataReceiver.createFlightList(airports);

        showAllFlightFrom(WARSZAWA,flightsList);
        showAllFlightFrom("KATOWICE",flightsList);

        showAllFlightTo(GDANSK,flightsList);
        showAllFlightTo("KATOWICE",flightsList);

        showConnectionBetweenAirports(WARSZAWA,KRAKOW,flightsList);
        showConnectionBetweenAirports(WARSZAWA,RZESZOW,flightsList);
        showConnectionBetweenAirports("KATOWICE",KRAKOW,flightsList);

        showTransferFlight(GDANSK,KRAKOW,WARSZAWA,flightsList);
        showTransferFlight(WARSZAWA,RZESZOW,KRAKOW,flightsList);


    }

}
