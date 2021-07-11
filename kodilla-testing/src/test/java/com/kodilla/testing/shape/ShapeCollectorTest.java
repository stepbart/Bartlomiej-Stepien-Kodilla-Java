package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

public class ShapeCollectorTest {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Figure Collection Tests")
    class FigureCollectionTests {
        @Test
        void addFigureTest() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Triangle("New Triangle"));

            //Then
            Assertions.assertEquals(1, shapeCollector.getFigureList().size());
        }

        @Test
        void removeFigureTest() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shapeTest = new Circle("New Circle");
            shapeCollector.addFigure(shapeTest);

            //When
            shapeCollector.removeFigure(shapeTest);
            boolean result = shapeCollector.getFigureList().size() > 0;

            //Then
            Assertions.assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Figure operation tests")
    class FigureOperationTests {
        @Test
        void getFigureTest() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shapeTest = new Circle("New Circle");
            shapeCollector.addFigure(shapeTest);

            //When
            boolean result = shapeCollector.getFigure(0).equals(shapeTest);

            //Then
            Assertions.assertTrue(result);

        }

        @Test
        void showFiguresTest() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape figure1 = new Circle("New Circle");
            Shape figure2 = new Triangle("New Triangle");
            Shape figure3 = new Square("New Square");
            shapeCollector.addFigure(figure1);
            shapeCollector.addFigure(figure2);
            shapeCollector.addFigure(figure3);
            String expectedResult = "New Circle, New Triangle, New Square";

            //When
            String textTest = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals(textTest, expectedResult);
        }
    }

}
