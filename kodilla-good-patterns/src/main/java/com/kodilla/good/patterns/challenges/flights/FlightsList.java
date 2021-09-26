package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsList {
    private List<Flight> flightList = new ArrayList<>();

    public void addFlight(Flight flight){
        flightList.add(flight);
    }

    public List<Flight> getFlightList(){
        return flightList;
    }

    @Override
    public String toString() {
        String introduceFlights = "Available flights: "+"\n";
        String showFlights = null;
        for (Flight f : flightList){
            showFlights = f+"\n";
            introduceFlights += showFlights;
        }
        return introduceFlights;
    }

    public FlightsList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public FlightsList() {
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
    public void mergeFlightLists(FlightsList flightsListToMerge){
        this.getFlightList().add(flightsListToMerge.getFlightList().get(0));
    }
}
