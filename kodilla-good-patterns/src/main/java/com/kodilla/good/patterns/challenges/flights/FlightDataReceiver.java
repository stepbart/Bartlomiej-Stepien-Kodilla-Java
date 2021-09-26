package com.kodilla.good.patterns.challenges.flights;

import static com.kodilla.good.patterns.challenges.flights.Constants.*;

public class FlightDataReceiver {

    public static Airports createAirportsList(){
        Airports airports = new Airports();

        airports.addAirport(GDANSK);
        airports.addAirport(KRAKOW);
        airports.addAirport(POZNAN);
        airports.addAirport(RZESZOW);
        airports.addAirport(SZCZECIN);
        airports.addAirport(WARSZAWA);
        airports.addAirport(WROCLAW);
        return airports;
    }

    public static FlightsList createFlightList(Airports airports){
        FlightsList flightsList = new FlightsList();

        flightsList.addFlight(new Flight(airports.getAirport(GDANSK),airports.getAirport(KRAKOW),1));
        flightsList.addFlight(new Flight(airports.getAirport(GDANSK),airports.getAirport(WARSZAWA),2));
        flightsList.addFlight(new Flight(airports.getAirport(KRAKOW),airports.getAirport(WARSZAWA),3));
        flightsList.addFlight(new Flight(airports.getAirport(KRAKOW),airports.getAirport(RZESZOW),4));
        flightsList.addFlight(new Flight(airports.getAirport(POZNAN),airports.getAirport(GDANSK),5));
        flightsList.addFlight(new Flight(airports.getAirport(POZNAN),airports.getAirport(WARSZAWA),6));
        flightsList.addFlight(new Flight(airports.getAirport(RZESZOW),airports.getAirport(SZCZECIN),7));
        flightsList.addFlight(new Flight(airports.getAirport(RZESZOW),airports.getAirport(WARSZAWA),8));
        flightsList.addFlight(new Flight(airports.getAirport(SZCZECIN),airports.getAirport(KRAKOW),9));
        flightsList.addFlight(new Flight(airports.getAirport(SZCZECIN),airports.getAirport(WARSZAWA),10));
        flightsList.addFlight(new Flight(airports.getAirport(WARSZAWA),airports.getAirport(KRAKOW),11));
        flightsList.addFlight(new Flight(airports.getAirport(WARSZAWA),airports.getAirport(GDANSK),12));
        flightsList.addFlight(new Flight(airports.getAirport(WARSZAWA),airports.getAirport(POZNAN),13));
        flightsList.addFlight(new Flight(airports.getAirport(WROCLAW),airports.getAirport(WARSZAWA),14));
        return flightsList;
    }


}
