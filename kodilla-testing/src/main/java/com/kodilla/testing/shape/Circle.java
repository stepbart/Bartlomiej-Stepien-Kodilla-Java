package com.kodilla.testing.shape;

public class Circle implements Shape{
    private String shapeName;
    private double field;

    public Circle(String shapeName) {
        this.shapeName = shapeName;
    }

    public Circle(String shapeName, double field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getField() {
        return 0;
    }
}
