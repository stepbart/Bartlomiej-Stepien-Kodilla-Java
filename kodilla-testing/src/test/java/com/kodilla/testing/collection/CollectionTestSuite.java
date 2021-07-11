package com.kodilla.testing.collection;
import com.kodilla.testing.collection.OddNumbersExterminator;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("when use exterminate method on empty List" +
            "then exterminate() should return empty List"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumberTestObject = new OddNumbersExterminator();
        List<Integer> emptyTestList = new ArrayList<>();
        //When
        List<Integer> newTestList = oddNumberTestObject.exterminate(emptyTestList);
        System.out.println("Testing List contains: " + newTestList);
        //Then
        Assertions.assertEquals(emptyTestList,newTestList);
    }

    @DisplayName("when use exterminate on List with even and odd numbers" +
            "then exterminate() should return List without odd numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumberTestObject = new OddNumbersExterminator();
        List<Integer> emptyTestList = Arrays.asList(1,2,3,4,5,6,17,170,1700,170007,-4);
        boolean hasOddNumbers = true;
        //When
        List<Integer> newTestList = oddNumberTestObject.exterminate(emptyTestList);
        System.out.println("Testing List contains: " + newTestList);
        //Then
        for (int testNumber : newTestList){
            if ((testNumber%2)!=0){
                hasOddNumbers = false;
            }
        }
        Assertions.assertTrue(hasOddNumbers);
    }
}
