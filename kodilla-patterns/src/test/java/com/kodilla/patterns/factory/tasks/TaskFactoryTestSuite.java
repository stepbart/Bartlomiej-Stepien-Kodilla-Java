package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task testTask = taskFactory.newTask(TaskFactory.SHOPPING_TASK);

        //When & Then
        Assertions.assertEquals(testTask.getTaskName(),"Shopping List");
        Assertions.assertEquals(testTask.isTaskExecuted(),false);
    }

    @Test
    void testFactoryPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task testTask = taskFactory.newTask(TaskFactory.PAINTING_TASK);

        //When & Then
        Assertions.assertEquals(testTask.getTaskName(),"Painting order");
        Assertions.assertEquals(testTask.isTaskExecuted(),false);
    }

    @Test
    void testFactoryDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task testTask = taskFactory.newTask(TaskFactory.DRIVING_TASK);

        //When & Then
        Assertions.assertEquals(testTask.getTaskName(),"Transport Order");
        Assertions.assertEquals(testTask.isTaskExecuted(),false);
    }

    @Test
    void testFactoryIsTaskExecuted(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task testTask1 = taskFactory.newTask(TaskFactory.SHOPPING_TASK);
        Task testTask2 = taskFactory.newTask(TaskFactory.PAINTING_TASK);
        Task testTask3 = taskFactory.newTask(TaskFactory.DRIVING_TASK);

        //When
        testTask1.executeTask();
        testTask2.executeTask();
        testTask3.executeTask();

        //Then
        Assertions.assertEquals(testTask1.isTaskExecuted(),true);
        Assertions.assertEquals(testTask2.isTaskExecuted(),true);
        Assertions.assertEquals(testTask3.isTaskExecuted(),true);
    }
}
