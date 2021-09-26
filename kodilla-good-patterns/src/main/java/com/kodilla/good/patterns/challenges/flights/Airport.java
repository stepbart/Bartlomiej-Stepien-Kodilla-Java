package com.kodilla.good.patterns.challenges.flights;

public class Airport {
    String name;
    int number = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return number == airport.number;
    }

    @Override
    public int hashCode() {
        return number;
    }


}
