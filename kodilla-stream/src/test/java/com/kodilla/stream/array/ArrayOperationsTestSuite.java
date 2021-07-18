package com.kodilla.stream.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] testArray1 = {1, 3, 14, 100, 345, 6098, 700000};
        int[] testArray2 = {3, 3, 3, 3};
        int[] testArray3 = {100};
        int[] testArray4 = new int[0];

        //When
        double average1 = ArrayOperations.getAverage(testArray1);
        double average2 = ArrayOperations.getAverage(testArray2);
        double average3 = ArrayOperations.getAverage(testArray3);
        double average4 = ArrayOperations.getAverage(testArray4);

        //Then
        assertEquals(average1, 100937.285, 0.001);
        assertEquals(average2, 3);
        assertEquals(average3, 100);
        assertEquals(average4, 0);

    }
}
