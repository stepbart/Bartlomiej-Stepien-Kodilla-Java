package com.kodilla.exception.test;

public class FlightSearchEnginge {

    public static void main(String[] args) {
        Flight testFlight1 = new Flight("Berlin", "New York");
        Flight testFlight2 = new Flight("Berlin", "Szczecin");
        Flight testFlight3 = new Flight("Frankfurt", "Rzeszów");

        FlightSearching fs = new FlightSearching();


        //Lotniska są na mapie i lot jest możliwy
        try {
            boolean a = fs.findFilght(testFlight1);
            System.out.println(a);
        } catch (RouteNotFoundException rnfexception) {
            System.out.println("Lotniska nie ma na mapie.");
        }

        //Lotniska są na mapie, ale lot jest niemożliwy
        try {
            boolean b = fs.findFilght(testFlight2);
            System.out.println(b);
        } catch (RouteNotFoundException rnfexception) {
            System.out.println("Lotniska nie ma na mapie.");
        }

        //Lotniska nie ma na mapie
        try {
            boolean c = fs.findFilght(testFlight3);
            System.out.println(c);
        } catch (RouteNotFoundException rnfexception) {
            System.out.println("Lotniska nie ma na mapie.");
        }
    }
}
