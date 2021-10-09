package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "Shopping Task";
    public static final String PAINTING_TASK = "Painting Task";
    public static final String DRIVING_TASK = "Driving Task";

    public Task newTask(final String taskType) {
        switch (taskType) {
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping List", "Building Materials", 20.0);
            case PAINTING_TASK:
                return new PaintingTask("Painting order", "white", "Apartment");
            case DRIVING_TASK:
                return new DrivingTask("Transport Order", "Gdynia", "Transport Bus");
            default:
                return null;
        }
    }
}
