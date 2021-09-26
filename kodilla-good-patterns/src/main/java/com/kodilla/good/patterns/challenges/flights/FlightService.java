package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

//znalezienie lotów poprzez inne miasto np. lot z Gdańska przez Kraków do Wrocławia.

    private static boolean isFlightFrom(String name, FlightsList flightsList) {
        boolean isFlight = false;
        for (Flight f : flightsList.getFlightList()) {
            if (f.getDepartureAirport().getName().equals(name)) {
                isFlight = true;
            }
        }
        return isFlight;
    }

    private static boolean isFlightTo(String name, FlightsList flightsList) {
        boolean isFlight = false;
        for (Flight f : flightsList.getFlightList()) {
            if (f.getArrivalAirport().getName().equals(name)) {
                isFlight = true;
            }
        }
        return isFlight;
    }

    public static FlightsList getAllFlightsFrom(String name, FlightsList flightsList) {
        FlightsList availableFlights = new FlightsList();
        if (isFlightFrom(name, flightsList)) {
            availableFlights.setFlightList(flightsList.getFlightList().stream()
                    .filter(flight -> flight.getDepartureAirport().getName().equals(name))
                    .collect(Collectors.toList()));
        }
        return availableFlights;
    }

    public static FlightsList getAllFlightsTo(String name, FlightsList flightsList) {
        FlightsList availableFlights = new FlightsList();
        if (isFlightTo(name, flightsList)) {
            availableFlights.setFlightList(flightsList.getFlightList().stream()
                    .filter(flight -> flight.getArrivalAirport().getName().equals(name))
                    .collect(Collectors.toList()));
        }
        return availableFlights;
    }

    public static boolean isFlightFromTo(String departure, String arrival, FlightsList flightsList) {
        FlightsList availableFlights = new FlightsList();

        if (isFlightFrom(departure, flightsList) && isFlightTo(arrival, flightsList)) {
            availableFlights.setFlightList(flightsList.getFlightList().stream()
                    .filter(flight -> flight.getDepartureAirport().getName().equals(departure))
                    .filter(flight -> flight.getArrivalAirport().getName().equals(arrival))
                    .collect(Collectors.toList()));
        }
        return !availableFlights.getFlightList().isEmpty();
    }

    public static FlightsList getFlightFromTo(String departure, String arrival, FlightsList flightsList) {
        FlightsList availableFlights = new FlightsList();

        if (isFlightFromTo(departure,arrival,flightsList)) {
            availableFlights.setFlightList(flightsList.getFlightList().stream()
                    .filter(flight -> flight.getDepartureAirport().getName().equals(departure))
                    .filter(flight -> flight.getArrivalAirport().getName().equals(arrival))
                    .collect(Collectors.toList()));
        }
        return availableFlights;
    }

    public static boolean isOneTransferFlightFromTo(String departure, String arrival, FlightsList flightsList) {
        FlightsList flightsFrom = getAllFlightsFrom(departure,flightsList);

        FlightsList flights = new FlightsList();

        for (Flight f : flightsFrom.getFlightList()){
            if (isFlightFromTo(f.getArrivalAirport().getName(),arrival,flightsList)){
                flights = getFlightFromTo(departure,f.getArrivalAirport().getName(),flightsList);
                flights.mergeFlightLists(getFlightFromTo(f.getArrivalAirport().getName(),arrival,flightsList));
            }
        }
        return !flights.getFlightList().isEmpty();
    }

    public static FlightsList getOneTransferFlights(String departure, String arrival, FlightsList flightsList){
        FlightsList flightsFrom = getAllFlightsFrom(departure,flightsList);

        FlightsList flights = new FlightsList();

        for (Flight f : flightsFrom.getFlightList()){
            if (isFlightFromTo(f.getArrivalAirport().getName(),arrival,flightsList)){
                flights = getFlightFromTo(departure,f.getArrivalAirport().getName(),flightsList);
                flights.mergeFlightLists(getFlightFromTo(f.getArrivalAirport().getName(),arrival,flightsList));
            }
        }

        return flights;
    }

    public static boolean isTransferFlight(String departure, String transfer, String arrival, FlightsList flightsList) {
        FlightsList flights = new FlightsList();

        if (isFlightFromTo(departure,transfer,flightsList) && isFlightFromTo(transfer,arrival,flightsList)){
            flights = getFlightFromTo(departure,transfer,flightsList);
            flights.mergeFlightLists(getFlightFromTo(transfer,arrival,flightsList));
        }
        return !flights.getFlightList().isEmpty();
    }

    public static FlightsList searchTransferFlight(String departure, String transfer, String arrival, FlightsList flightsList){
        FlightsList flights = new FlightsList();

        if (isFlightFromTo(departure,transfer,flightsList) && isFlightFromTo(transfer,arrival,flightsList)){
            flights = getFlightFromTo(departure,transfer,flightsList);
            flights.mergeFlightLists(getFlightFromTo(transfer,arrival,flightsList));
        }
        return flights;
    }

    public static void showAllFlightFrom(String departureAirport, FlightsList flightsList){
        if (isFlightFrom(departureAirport,flightsList)){
            System.out.println(getAllFlightsFrom(departureAirport,flightsList));
        }
        else{
            System.out.println("We are sorry, there is no flight from "+departureAirport+".");
        }
    }

    public static void showAllFlightTo(String arrivalAirport, FlightsList flightsList){
        if (isFlightTo(arrivalAirport,flightsList)){
            System.out.println(getAllFlightsTo(arrivalAirport,flightsList));
        }
        else{
            System.out.println("We are sorry, there is no flight to "+arrivalAirport+".");
        }
    }

    public static void showConnectionBetweenAirports(String departureAirport, String arrivalAirport, FlightsList flightsList){
        if (isFlightFromTo(departureAirport,arrivalAirport,flightsList)){
            System.out.println(getFlightFromTo(departureAirport,arrivalAirport,flightsList));
        }
        else if (isOneTransferFlightFromTo(departureAirport,arrivalAirport,flightsList)){
            System.out.println("We have no direct connection, but there is available connecting flights:");
            System.out.println(getOneTransferFlights(departureAirport,arrivalAirport,flightsList));
        }
        else
        {
            System.out.println("We are sorry, there is no connection between "+departureAirport+" and "+arrivalAirport+".");
        }
    }

    public static void showTransferFlight(String departure, String transfer, String arrival, FlightsList flightsList){
        if (isTransferFlight(departure,transfer,arrival,flightsList)){
            System.out.println(searchTransferFlight(departure,transfer,arrival,flightsList));
        }
        else
        {
            System.out.println("We are sorry, there is no connection available!");
        }
    }

}