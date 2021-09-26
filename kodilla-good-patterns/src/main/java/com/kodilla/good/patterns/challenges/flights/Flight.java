package com.kodilla.good.patterns.challenges.flights;

public class Flight {
    private Airport departureAirport;
    private Airport arrivalAirport;
    private int flightNumber;

    public Flight(Airport departureAirport, Airport arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;

    }

    public Flight(Airport departureAirport, Airport arrivalAirport, int flightNumber) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        String showFlight = "Flight from: "+departureAirport.getName()+" to: "+arrivalAirport.getName()+"(Flight Nr : "+flightNumber+")";
        return showFlight;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (departureAirport != null ? !departureAirport.equals(flight.departureAirport) : flight.departureAirport != null)
            return false;
        return arrivalAirport != null ? arrivalAirport.equals(flight.arrivalAirport) : flight.arrivalAirport == null;
    }

    @Override
    public int hashCode() {
        int x = departureAirport.number;
        int y = arrivalAirport.number;
        int newID = Integer.parseInt((Integer.toString(x))+""+(Integer.toString(y)));
        if (departureAirport.number==0 && arrivalAirport.number==0){
            newID = 0;
        }
        return newID;
    }
}
