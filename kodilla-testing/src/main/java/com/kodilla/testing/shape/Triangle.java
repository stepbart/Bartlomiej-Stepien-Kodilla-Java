package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private String shapeName;
    private double field;

    public Triangle(String shapeName) {
        this.shapeName = shapeName;
    }

    public Triangle(String shapeName, double field) {
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
